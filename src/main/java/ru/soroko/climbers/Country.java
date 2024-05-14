package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_countries")
public class Country {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Country(String name) {
        if ("".equals(name))
            throw new IllegalArgumentException("Название страны не может быть пустой строкой");
        this.name = name;
    }
}
