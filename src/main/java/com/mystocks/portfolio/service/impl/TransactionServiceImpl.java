package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.model.Transaction;
import com.mystocks.portfolio.model.dto.TransactionRequest;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.repo.TransactionRepository;
import com.mystocks.portfolio.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final PortfolioRepository portfolioRepository;

    @Override
    public Transaction createTransaction(TransactionRequest transactionRequest) {
        Portfolio portfolio = portfolioRepository.findById(transactionRequest.portfolioId())
                .orElseThrow(() -> new RuntimeException("Portfolio does not exist."));
        return transactionRepository.save(Transaction.builder()
                .transactionDate(transactionRequest.transactionDate())
                .amount(transactionRequest.amount())
                .transactionType(transactionRequest.transactionType())
                .stockCode(transactionRequest.stockCode())
                .portfolio(portfolio)
                .build());
    }
}
