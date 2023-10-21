package controller;
import java.util.*;
import model.Transaction;

public interface TransactionFilter {
    List<Integer> filter(List<Transaction> transactions);
}
