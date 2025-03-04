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

    @OneToMany(mappedBy = "portfolio",cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIgnore
    private List<Stock> stockList;

    @OneToMany(mappedBy = "portfolio",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Transaction> transactionList;

    public void addStock(String stockCode, Integer amount){
        Stock stock = new Stock();
        stock.setStockCode(stockCode);
        stock.setAmount(amount);
        stock.setPortfolio(this);
        this.stockList.add(stock);
    }

    public void subtractStock(String stockCode, Integer amount){
        Stock stock = stockList.stream().filter(s -> s.getStockCode().equals(stockCode)).findFirst().
                orElseThrow(() -> new RuntimeException("Stock not exist."));

        if(stock.getAmount() < amount) throw new RuntimeException("Insufficient stock amount.");
        stock.setAmount(stock.getAmount() - amount);
        if(stock.getAmount() == 0) stockList.remove(stock);
    }
}
