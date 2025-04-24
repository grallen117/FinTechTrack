package com.gary.fintechtrack.util;

import com.gary.fintechtrack.model.CryptoCoin;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

@Component
public class CoinGeckoClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<CryptoCoin> getTopCoins(int limit) {
        //Create end point from CoinGecko API
        String url = "https://api.coingecko.com/api/v3/coins/markets" +
                "?vs_currency=usd&order=market_cap_desc&per_page=" +
                limit + "&page=1&sparkline=false";

        ResponseEntity<List<CryptoCoin>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody();
    }

}
