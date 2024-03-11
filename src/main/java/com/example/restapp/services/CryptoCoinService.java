package com.example.restapp.services;

import com.example.restapp.entities.CryptoCoin;
import com.example.restapp.repositories.CryptoCoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class CryptoCoinService {

    private final CryptoCoinRepository cryptoCoinRepository;

    public CryptoCoin getById(String id) {
        return cryptoCoinRepository.findById(id).orElseThrow();
    }

    public CryptoCoin getByName(String name) {
        return cryptoCoinRepository.findByName(name);
    }

    public Collection<CryptoCoin> getAll() {
        return cryptoCoinRepository.findAll();
    }

    public void create(CryptoCoin cryptoCoin) {
        cryptoCoinRepository.save(cryptoCoin);
    }
}
