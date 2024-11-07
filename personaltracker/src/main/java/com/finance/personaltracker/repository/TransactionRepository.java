package com.finance.personaltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.personaltracker.model.Transaction;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findByType(String type);
}
