package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country country;

    @Positive
    @Size(min = 100)
    @Column(name = "height", nullable = false)
    private int height;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ascension_id", nullable = false)
    private Ascension ascension;

}
