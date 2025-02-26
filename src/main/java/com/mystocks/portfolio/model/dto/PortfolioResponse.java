package com.mystocks.portfolio.model.dto;


public record PortfolioResponse(
        String portfolioName,
        long userId,
        boolean isPortfolioActive
) {
}
