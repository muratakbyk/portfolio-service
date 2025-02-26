package com.mystocks.portfolio.repo;

import com.mystocks.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    Optional<Portfolio> findByUserId(Long userId);
    boolean existsByPortfolioNameAndUserId(String portfolioName, long userId);

}
