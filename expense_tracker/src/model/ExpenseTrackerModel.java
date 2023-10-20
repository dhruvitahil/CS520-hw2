package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerModel {

  // Implemented encapsulation and immutability by using keywords private and final
  private final List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }


  //The method interanlly creates an object instead of passing the object as a parameter to prevnt external data modification
  public void addTransaction(double amount, String category) {
    Transaction t = new Transaction(amount, category);
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {

    //Impleted immutability by return an unmodifable list of transactions
    return Collections.unmodifiableList(transactions);
  }

}