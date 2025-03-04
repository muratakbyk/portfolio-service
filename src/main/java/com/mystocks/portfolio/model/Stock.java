package com.mystocks.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    private String stockCode;
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID", nullable = false)
    private Portfolio portfolio;

}
