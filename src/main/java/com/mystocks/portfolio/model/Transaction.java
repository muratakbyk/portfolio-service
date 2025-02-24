package com.mystocks.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mystocks.portfolio.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal transactionCost;
    private LocalDateTime transactionDate;
    private String stockCode;
    private Integer stockQuantity;
    private BigDecimal lotPrice;

    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    private Portfolio portfolio;


}

