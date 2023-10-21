package controller;
import java.util.*;
import model.Transaction;
public class CategoryFilter implements TransactionFilter {
    private String filterCategory;
    //implementing encapsulation
    public CategoryFilter(String filterCategory) {
        this.filterCategory = filterCategory;
    }

    @Override
    public List<Integer> filter(List<Transaction> transactions) {
        List<Integer> filteredRows = new ArrayList<>();
        String category = "";
        for (int i = 0; i < transactions.size(); i++) {
            category = transactions.get(i).getCategory();
            if (category.equalsIgnoreCase(filterCategory)) {
                filteredRows.add(i);
            }
        }
        return filteredRows;
    }
}