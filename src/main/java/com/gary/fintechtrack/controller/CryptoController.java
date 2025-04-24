package com.gary.fintechtrack.controller;

import com.gary.fintechtrack.model.CryptoCoin;
import com.gary.fintechtrack.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/top")
    public List<CryptoCoin> getTopCoins(@RequestParam(defaultValue = "20") int limit) {
        List<CryptoCoin> coins = cryptoService.getTopCoins(limit);

        coins.forEach(coin -> {
            System.out.println("Formatted Market Cap: " + coin.getFormattedMarketCap());
            System.out.println("Formatted Current Price: " + coin.getFormattedCurrentPrice());
        });
        return coins;
    }


}
