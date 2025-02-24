package com.mystocks.portfolio.model.dto;

import com.mystocks.portfolio.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequest(Long portfolioId,
                                 TransactionType transactionType,
                                 BigDecimal transactionCost,
                                 LocalDateTime transactionDate,
                                 String stockCode,
                                 Integer stockQuantity) {
}
