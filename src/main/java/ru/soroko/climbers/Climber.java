package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_climbers")
public class Climber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Positive
    @Column(name = "phoneNumber", unique = true, nullable = false)
    private long phoneNumber;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 50)
    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;

    @NotNull
    @Column(name = "last_ascension", nullable = false)
    private LocalDate lastAscension;

}
