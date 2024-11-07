package com.finance.personaltracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Transaction> getTransactionByType(String type) {
        return transactionRepository.findByType(type);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
