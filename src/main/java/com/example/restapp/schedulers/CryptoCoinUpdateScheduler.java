package com.example.restapp.schedulers;

import com.example.restapp.entities.CryptoCoin;
import com.example.restapp.repositories.CryptoCoinRepository;
import com.example.restapp.services.MinerstatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CryptoCoinUpdateScheduler {
    @Autowired
    private MinerstatService minerstatService;
    @Autowired
    private CryptoCoinRepository cryptoCoinRepository;

    @Scheduled(fixedRate = 600_000)
    public void update() {
        try {
             CryptoCoin[] cryptoCoins = minerstatService.fetchCryptoCoins();
             for (CryptoCoin cryptoCoin : cryptoCoins) {
                 CryptoCoin coin = cryptoCoinRepository.findByName(cryptoCoin.getName());
                 if (coin != null) {
                     coin.setPrice(cryptoCoin.getPrice());
                     cryptoCoinRepository.save(coin);
                     log.info("Добавлена новая монета: " + coin.getName() + ", цена $" + coin.getPrice());
                 } else {
                     cryptoCoinRepository.save(cryptoCoin);
                     log.info("Добавлена новая монета: " + cryptoCoin.getName() + ", цена $" + coin.getPrice());
                 }
             }
        } catch (Exception e) {
            log.error("Ошибка добавления новой монеты");
        }
    }
}
