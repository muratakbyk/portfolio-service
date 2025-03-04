package com.mystocks.portfolio.model.mapper;

import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.dto.PortfolioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {

    @Mapping(source = "portfolioName", target = "portfolioName")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "portfolioActive", target = "isPortfolioActive")
    PortfolioResponse toResponse(Portfolio portfolio);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    Portfolio toEntity(PortfolioRequest request);

    default Portfolio toEntityWithUserId(PortfolioRequest request, long userId) {
        Portfolio portfolio = toEntity(request);
        portfolio.setUserId(userId);
        return portfolio;
    }
}
