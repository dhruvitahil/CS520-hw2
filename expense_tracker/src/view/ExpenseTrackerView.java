package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.DefaultTableCellRenderer;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  //new buttons added
  private JButton filterAmountButton;
  private JButton filterCategoryButton;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Integer> filterTransactions;

  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(1000, 1000); // Make GUI larger

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");
    filterAmountButton = new JButton("Filter by Amount"); //adding Jbutton
    filterCategoryButton = new JButton("Filter by Category");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);

    //highlighting the filtered rows
    transactionsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                        boolean hasFocus, int row, int column) {
              Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
              if (getFilteredTransaction() != null) {
                boolean isPresent = getFilteredTransaction().contains(row);
                if(isPresent){
                  c.setBackground(new Color(173, 255, 168)); // Light green
                }
               else {
                  c.setBackground(table.getBackground());
              }
            }
              return c;
          }
      });
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
    //adding in layout
    inputPanel.add(filterAmountButton);
    inputPanel.add(filterCategoryButton);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
    buttonPanel.add(filterAmountButton); //adding on JPanel
    buttonPanel.add(filterCategoryButton);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(650, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) {
      // Clear existing rows
      model.setRowCount(0);
      // Get row count
      int rowNum = model.getRowCount();
      double totalCost=0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()}); 
      }
        // Add total row
        Object[] totalRow = {"Total", null, null, totalCost};
        model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  
  

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

//adding getter method
  public JButton getFilterAmountButton() {
        return filterAmountButton;
  }

  public JButton getFilterCategoryButton() {
        return filterCategoryButton;
  }

  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
    public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

//getter and setter methods for filtered transaction
  public List<Integer> getFilteredTransaction() {
    return filterTransactions;
  }

  public void setFilteredTransaction(List<Integer> filterTransactions) {
    this.filterTransactions = filterTransactions;
  }
}
