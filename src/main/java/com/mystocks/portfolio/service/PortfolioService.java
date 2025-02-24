package com.mystocks.portfolio.service;


import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;

public interface PortfolioService {
     Portfolio createPortfolio(PortfolioRequest portfolioRequest);
     Portfolio getPortfolioById(Long portfolioId);
}
