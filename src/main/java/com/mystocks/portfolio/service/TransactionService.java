package com.mystocks.portfolio.service;

import com.mystocks.portfolio.model.Transaction;
import com.mystocks.portfolio.model.dto.TransactionRequest;

public interface TransactionService {
    Transaction createTransaction(TransactionRequest transactionRequest);
}
