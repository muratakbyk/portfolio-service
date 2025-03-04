package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.model.Transaction;
import com.mystocks.portfolio.model.dto.TransactionRequest;
import com.mystocks.portfolio.model.enums.TransactionType;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.repo.TransactionRepository;
import com.mystocks.portfolio.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final PortfolioRepository portfolioRepository;

    @Override
    public Transaction createTransaction(TransactionRequest transactionRequest) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(transactionRequest.portfolioId());

        if(transactionRequest.transactionType().equals(TransactionType.BUY)){
            portfolio.get().addStock(transactionRequest.stockCode(),transactionRequest.stockQuantity());
        }
        else if(transactionRequest.transactionType().equals(TransactionType.SELL)){
            portfolio.get().subtractStock(transactionRequest.stockCode(),transactionRequest.stockQuantity());
        }
        return transactionRepository.save(Transaction.builder()
                .transactionDate(transactionRequest.transactionDate())
                .transactionCost(transactionRequest.transactionCost())
                .stockQuantity(transactionRequest.stockQuantity())
                .transactionType(transactionRequest.transactionType())
                .stockCode(transactionRequest.stockCode())
                .portfolio(portfolio.get())
                .lotPrice(transactionRequest.transactionCost().divide(BigDecimal.valueOf(transactionRequest.stockQuantity())))
                .build());
    }
    @Override
    public Transaction deleteTransaction(Long transactionId){
        transactionRepository.deleteById(transactionId);
        return new Transaction();
    }


}
