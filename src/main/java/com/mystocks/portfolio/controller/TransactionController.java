package com.mystocks.portfolio.controller;

import com.mystocks.portfolio.model.Transaction;
import com.mystocks.portfolio.model.dto.TransactionRequest;
import com.mystocks.portfolio.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionRequest));
    }

    @GetMapping("/deleteTransaction")
    public ResponseEntity<Transaction> deleteTransaction(@RequestParam Long transactionId) {
        return ResponseEntity.ok(transactionService.deleteTransaction(transactionId));
    }
}
