package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "tb_mountains")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country country;*/
    @NotNull
    @ManyToMany
    @JoinTable(name = "tb_mountain_countries",
            joinColumns = @JoinColumn(name = "mountain_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countries = new ArrayList<>();

    @Positive
    @Size(min = 100)
    @Column(name = "height", nullable = false)
    private int height;

    /*@ManyToOne
    @JoinColumn(name = "ascension_id", nullable = false)
    private Ascension ascension;*/
    @NotNull
    @OneToMany(mappedBy = "mountain")
    private List<Ascension> ascensions = new ArrayList<>();

}
