package com.mystocks.portfolio.controller;

import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/createPortfolio")
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody PortfolioRequest portfolioRequest,
                                     @RequestHeader("X-User-Id") Long userId){
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolioRequest,userId));
    }
}
