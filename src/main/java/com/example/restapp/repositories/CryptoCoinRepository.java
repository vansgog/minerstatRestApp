package com.example.restapp.repositories;

import com.example.restapp.entities.CryptoCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCoinRepository extends JpaRepository<CryptoCoin, String> {
    CryptoCoin findByName(String name);
}