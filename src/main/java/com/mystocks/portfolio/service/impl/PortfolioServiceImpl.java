package com.mystocks.portfolio.service.impl;

import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.model.dto.PortfolioResponse;
import com.mystocks.portfolio.model.mapper.PortfolioMapper;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.security.PortfolioSecurityProvider;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioSecurityProvider portfolioSecurityProvider;
    private final PortfolioMapper portfolioMapper;
    @Override
    public PortfolioResponse createPortfolio(PortfolioRequest portfolioRequest) {
        Long userId = portfolioSecurityProvider.extractUserId();
        if (portfolioRepository.existsByPortfolioNameAndUserId(portfolioRequest.portfolioName(), userId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        Portfolio savedPortfolio = portfolioRepository.save(portfolioMapper.toEntityWithUserId(portfolioRequest,userId));
        return portfolioMapper.toResponse(savedPortfolio);
    }

    @Override
    public PortfolioResponse getPortfolioById(Long portfolioId) {
        //Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
        return new PortfolioResponse("",1L,true);
    }

}
