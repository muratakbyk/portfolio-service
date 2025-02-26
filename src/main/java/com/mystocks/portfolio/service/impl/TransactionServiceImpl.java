package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.Transaction;
import com.mystocks.portfolio.model.dto.TransactionRequest;
import com.mystocks.portfolio.repo.TransactionRepository;
import com.mystocks.portfolio.service.PortfolioService;
import com.mystocks.portfolio.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final PortfolioService portfolioService;

    @Override
    public Transaction createTransaction(TransactionRequest transactionRequest) {
        //Portfolio portfolio = portfolioService.getPortfolioById(transactionRequest.portfolioId());

        return transactionRepository.save(Transaction.builder()
                .transactionDate(transactionRequest.transactionDate())
                .transactionCost(transactionRequest.transactionCost())
                .stockQuantity(transactionRequest.stockQuantity())
                .transactionType(transactionRequest.transactionType())
                .stockCode(transactionRequest.stockCode())
             //   .portfolio(portfolio)
                .lotPrice(transactionRequest.transactionCost().divide(BigDecimal.valueOf(transactionRequest.stockQuantity())))
                .build());
    }
    @Override
    public Transaction deleteTransaction(Long transactionId){
        transactionRepository.deleteById(transactionId);
        return new Transaction();
    }


}
