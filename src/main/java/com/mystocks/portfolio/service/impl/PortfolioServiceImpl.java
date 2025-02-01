package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    @Override
    public Portfolio createPortfolio(PortfolioRequest portfolioRequest, Long userId) {
       return portfolioRepository.save(
               Portfolio.builder()
               .userId(userId)
               .portfolioName(portfolioRequest.portfolioName())
               .isPortfolioActive(portfolioRequest.isPortfolioActive())
               .currentBalance(new BigDecimal("0"))
               .stockList(List.of())
               .transactionList(List.of())
               .build());
    }

}
