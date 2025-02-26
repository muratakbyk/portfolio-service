package com.mystocks.portfolio.controller;

import com.mystocks.portfolio.core.util.ApiResponse;
import com.mystocks.portfolio.model.dto.PortfolioRequest;
import com.mystocks.portfolio.model.dto.PortfolioResponse;
import com.mystocks.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/createPortfolio")
    public ResponseEntity<ApiResponse<PortfolioResponse>> createPortfolio(@RequestBody PortfolioRequest portfolioRequest){
        PortfolioResponse portfolioResponse = portfolioService.createPortfolio(portfolioRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("",portfolioResponse));
    }
/*
    @GetMapping("/getPortfolio")
    @PreAuthorize("@portfolioSecurityProvider.isOwner(#portfolioId)")
    public ResponseEntity<Portfolio> getPortfolioById(@RequestParam Long portfolioId){
        return ResponseEntity.ok(portfolioService.getPortfolioById(portfolioId));
    }

*/
}
