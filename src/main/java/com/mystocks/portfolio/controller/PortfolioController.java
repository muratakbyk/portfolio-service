package com.mystocks.portfolio.controller;

import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.Portfolio;
import com.mystocks.portfolio.repo.PortfolioRepository;
import com.mystocks.portfolio.security.PortfolioSecurityProvider;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.Optional;


@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;


    @PostMapping("/createPortfolio")
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody PortfolioRequest portfolioRequest){
        return ResponseEntity.ok(portfolioService.createPortfolio(portfolioRequest));
    }

    @GetMapping("/getPortfolio")
    @PreAuthorize("@portfolioSecurityProvider.isOwner(#portfolioId)")
    public ResponseEntity<Portfolio> getPortfolioById(@RequestParam Long portfolioId){
        return ResponseEntity.ok(portfolioService.getPortfolioById(portfolioId));
    }


}
