package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.security.PortfolioSecurityProvider;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioSecurityProvider portfolioSecurityProvider;
    @Override
    public Portfolio createPortfolio(PortfolioRequest portfolioRequest) {
        Long userId = portfolioSecurityProvider.extractUserId();
       return portfolioRepository.save(
               Portfolio.builder()
               .portfolioName(portfolioRequest.portfolioName())
               .userId(userId)
               .isPortfolioActive(portfolioRequest.isPortfolioActive())
               .stockList(List.of())
               .transactionList(List.of())
               .build());
    }

    @Override
    public Portfolio getPortfolioById(Long portfolioId) {
        Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
        return portfolio.get();
    }

}
