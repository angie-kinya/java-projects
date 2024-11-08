package com.finance.personaltracker.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.finance.personaltracker.exception.ResourceNotFoundException;
import com.finance.personaltracker.model.Transaction;
import com.finance.personaltracker.service.TransactionService;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Page<Transaction> getAllTransactions(
            @PageableDefault(page = 0, size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable pageable) {
        return transactionService.getAllTransactions(pageable);
    }

    // Add endpoints for filtering
    @GetMapping("/filter/type")
    public List<Transaction> getTransactionsByType(@RequestParam String type) {
        return transactionService.getTransactionsByType(type);
    }

    @GetMapping("/filter/category")
    public List<Transaction> getTransactionsByCategory(@RequestParam String category) {
        return transactionService.getTransactionsByCategory(category);
    }

    @GetMapping("/filter")
    public List<Transaction> getTransactionsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return transactionService.getTransactionByDateRange(startDate, endDate);
    }

    @GetMapping("/summary")
    public Map<String, Double> getMonthlySummary(
            @RequestParam("month") int month,
            @RequestParam("year") int year) {
        return transactionService.getMonthlySummary(month, year);
    }
    
    @PostMapping 
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
