package com.mystocks.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PORTFOLIO")
public class Portfolio {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PORTFOLIO_NAME")
    private String portfolioName;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

    @Column(name = "IS_PORTFOLIO_ACTIVE")
    private boolean isPortfolioActive;

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "STOCK_NAME")
    private List<String> stockList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction> transactionList;

}
