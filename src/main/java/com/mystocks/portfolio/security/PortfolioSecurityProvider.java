package com.mystocks.portfolio.security;

import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.repo.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service("portfolioSecurityProvider")
@RequiredArgsConstructor
public class PortfolioSecurityProvider {
    private final PortfolioRepository portfolioRepository;

    public boolean isOwner(Long portfolioId){
        Long userId = extractUserId();
        Portfolio portfolio = portfolioRepository.findById(portfolioId).
                orElseThrow(() -> new RuntimeException("Portfolio not found."));
        return userId.equals(portfolio.getUserId());
    }

    public Long extractUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication.getPrincipal() instanceof Jwt)){
            throw new IllegalArgumentException("Jwt Token is not found.");
        }
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return jwt.getClaim("userId");
    }
}
