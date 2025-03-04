package com.mystocks.portfolio.model.dto;


public record PortfolioResponse(
        String portfolioName,
        long id,
        boolean isPortfolioActive
) {
}
