package com.example.restapp.services;

import com.example.restapp.entities.CryptoCoin;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MinerstatService {
    private final String API_URL = "https://api.minerstat.com/v2/coins";

    public CryptoCoin[] fetchCryptoCoins() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL, CryptoCoin[].class);
    }
}
