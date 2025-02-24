package com.mystocks.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    private String stockCode;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    private Portfolio portfolio;

}
