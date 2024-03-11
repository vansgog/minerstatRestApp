package com.example.restapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CryptoCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "Коин{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", цена=" + price +
                '}';
    }
}
