package com.hamrose.rentalservice.model;

import jakarta.persistence.*;
import lombok.Data;;

@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseNumber;
    private String fullName;
    private String phoneNumber;
    private String lastPaymentDate;
    private String nextPaymentDate;
}
