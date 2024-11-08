package com.finance.personaltracker.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finance.personaltracker.model.Transaction;
import com.finance.personaltracker.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByType(type);
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> getTransactionByDateRange(Date startDate, Date endDate) {
        return transactionRepository.findByDateBetween(startDate, endDate);
    }

    public Page<Transaction> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @SuppressWarnings("deprecation")
    public Map<String, Double> getMonthlySummary(int month, int year) {
        List<Transaction> transactions = transactionRepository.findAll();
        double totalIncome = 0.0;
        double totalExpense = 0.0;

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getMonth() == month -1 && transaction.getDate().getYear() + 1900 == year) {
                if ("Income".equalsIgnoreCase(transaction.getType())) {
                    totalIncome += transaction.getAmount();
                } else if ("Expense".equalsIgnoreCase(transaction.getType())) {
                    totalExpense += transaction.getAmount();
                }
            }
        }
        Map<String, Double> summary = new HashMap<>();
        summary.put("Total Income", totalIncome);
        summary.put("Total Expenses", totalExpense);
        summary.put("Net Balance", totalIncome - totalExpense);
        return summary;
    }

}

