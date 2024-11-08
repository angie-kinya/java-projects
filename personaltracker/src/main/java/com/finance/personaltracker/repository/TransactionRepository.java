package com.finance.personaltracker.repository;

import org.aspectj.weaver.tools.Traceable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.personaltracker.model.Transaction;

import java.util.Date;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findByType(String type);
    List<Transaction> findByDateBetween(Date startDate, Date endDate);
    Page<Transaction> findAll(Pageable pageable);
    List<Transaction> findByCategory(String category);
    List<Transaction> findByTypeAndCategory(String type, String category);
}
