package com.mystocks.portfolio.model;

import com.mystocks.portfolio.model.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @Column(name = "ID")
    private  Long id;

    @Column(name = "TRANSACTION_TYPE")
    private TransactionType transactionType;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    @Column(name = "STOCK_CODE")
    private String stockCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    private Portfolio portfolio;


}

