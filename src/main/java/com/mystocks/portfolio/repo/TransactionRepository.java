package com.mystocks.portfolio.repo;

import com.mystocks.portfolio.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
