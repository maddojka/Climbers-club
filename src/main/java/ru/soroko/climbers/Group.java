package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mountain_id", nullable = false)
    private Mountain mountain;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 100)
    @Column(name = "superior", nullable = false, length = 100)
    private String superior;

    @NotNull
    @Future
    @Column(name = "next_ascension", nullable = false)
    private LocalDateTime nextAscension;

    @Positive
    @Column(name = "max_climbers", nullable = false)
    private int maxClimbers;

    @Positive
    @Column(name = "cost", nullable = false)
    private double cost;

    @PositiveOrZero
    @Column(name = "amount_of_climbers", nullable = false)
    private int amountOfClimbers;
}
