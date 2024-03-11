package com.example.restapp.controllers;

import com.example.restapp.entities.CryptoCoin;
import com.example.restapp.services.CryptoCoinService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/crypto-coins")
public class CryptoCoinController {
    private CryptoCoinService cryptoCoinService;

    public CryptoCoinController(CryptoCoinService cryptoCoinService) {
        this.cryptoCoinService = cryptoCoinService;
    }

    @GetMapping("/{id}")
    public CryptoCoin getCryptoCoinById(@PathVariable String id) {
        return cryptoCoinService.getById(id);
    }

    @GetMapping("/{name}")
    public CryptoCoin getCryptoCoinByName(@PathVariable String name) {
        return cryptoCoinService.getByName(name);
    }

    @GetMapping
    public Collection<CryptoCoin> getAllCryptoCoins() {
        return cryptoCoinService.getAll();
    }

    @PostMapping
    public void createCoin(@RequestBody CryptoCoin cryptoCoin) {
        cryptoCoinService.create(cryptoCoin);
    }

}
