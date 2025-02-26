package com.mystocks.portfolio.service;


import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.model.dto.PortfolioResponse;

public interface PortfolioService {
     PortfolioResponse createPortfolio(PortfolioRequest portfolioRequest);
     PortfolioResponse getPortfolioById(Long portfolioId);
}
