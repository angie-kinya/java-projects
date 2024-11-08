package com.finance.personaltracker.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; //income or expense
    private String category;
    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String description;
}
