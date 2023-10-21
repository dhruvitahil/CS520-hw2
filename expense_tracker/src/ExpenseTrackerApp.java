import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import model.Transaction;
import controller.InputValidation;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });


     // Handle apply CATEGORY filter button clicks
    view.getFilterCategoryButton().addActionListener(e -> {
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      controller.applyCategoryFilter(category);

    });

     // Handle apply AMOUNT filter button clicks
    view.getFilterAmountButton().addActionListener(e -> {
      double maxAmount = view.getAmountField();
      
      // Call controller to add transaction
      controller.applyAmountFilter(maxAmount);

    });


  }

}