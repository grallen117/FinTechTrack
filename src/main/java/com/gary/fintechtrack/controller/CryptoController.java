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
        //Add the formatted prices to the return model object
        coins.forEach(coin -> {
            coin.setFormattedMarketCap(coin.getFormattedMarketCap());
            coin.setFormattedCurrentPrice(coin.getFormattedCurrentPrice());
        });
        return coins;
    }


}
