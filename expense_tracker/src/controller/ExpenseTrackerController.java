package controller;
import view.ExpenseTrackerView;
import java.util.*;

import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  private CategoryFilter cf;
  private AmountFilter af; 

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(amount, category);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }

//method added to apply CATEGORY filter
public void applyCategoryFilter(String category) {
    List<Transaction> transaction = model.getTransactions();
    cf = new CategoryFilter(category);
    List<Integer> categoryFilteredTransactions = cf.filter(transaction);
    view.setFilteredTransaction(categoryFilteredTransactions);
    refresh();
}

//method added to apply AMOUNT filter
public void applyAmountFilter(double maxAmount) {
    List<Transaction> transaction = model.getTransactions();
    af = new AmountFilter(maxAmount);
    List<Integer> amountFilteredTransactions = af.filter(transaction);
    view.setFilteredTransaction(amountFilteredTransactions);
    refresh();
}

}