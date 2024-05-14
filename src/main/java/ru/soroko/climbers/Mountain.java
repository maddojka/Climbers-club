package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_mountains")
public class Mountain {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "country", nullable = false)
    private Country country;
    @Column(name = "height", nullable = false)
    private int height;
    @ManyToOne
    @JoinColumn(name = "ascension_id", nullable = false)
    private Ascension ascension;

    public Mountain(String title, Country country, int height) {
        if ("".equals(title))
            throw new IllegalArgumentException("Название горы не может быть пустой строкой");
        if (country == null)
            throw new IllegalArgumentException("Название строны не может быть пустым");
        if (height < 100)
            throw new IllegalArgumentException("Высота горы не может быть меньше 100 м");
        this.title = title;
        this.country = country;
        this.height = height;
    }
}
