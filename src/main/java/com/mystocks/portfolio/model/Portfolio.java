package com.mystocks.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PORTFOLIO")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portfolioName;
    private long userId;
    private boolean isPortfolioActive;

    @OneToMany(mappedBy = "portfolio",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Stock> stockList;

    @OneToMany(mappedBy = "portfolio",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Transaction> transactionList;
}
