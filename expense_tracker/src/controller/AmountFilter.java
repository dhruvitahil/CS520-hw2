package controller;
import java.util.*;
import model.Transaction;

public class AmountFilter implements TransactionFilter {
    private double maxAmount;
    // implementing encapsulation
    public AmountFilter(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public List<Integer> filter(List<Transaction> transactions) {
        List<Integer> filteredRows = new ArrayList<>();
        double amount = 0.0;
        for (int i = 0; i < transactions.size(); i++) {
            amount = transactions.get(i).getAmount();
            if (amount <= maxAmount) {
                filteredRows.add(i);
            }
        }
        return filteredRows;
    }
}