package com.gary.fintechtrack.service;

import com.gary.fintechtrack.model.CryptoCoin;
import com.gary.fintechtrack.util.CoinGeckoClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoService {

    private final CoinGeckoClient client;

    public CryptoService(CoinGeckoClient client) {
        this.client = client;
    }

    public List<CryptoCoin> getTopCoins(int limit) {
        return client.getTopCoins(limit);
    }

}
