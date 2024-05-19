package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
        @NamedNativeQuery(name = "get_open_groups", query = "SELECT * " +
                "FROM tb_groups " +
                "WHERE tb_groups.amount_of_climbers < tb_groups.max_climbers " +
                "AND CURRENT_DATE < tb_groups.next_ascension "),
})
@Data
@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
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
    private LocalDate nextAscension;

    @Positive
    @Column(name = "max_climbers", nullable = false)
    private int maxClimbers;

    @Positive
    @Column(name = "cost", nullable = false)
    private double cost;

    @PositiveOrZero
    @Column(name = "amount_of_climbers", nullable = false)
    private int amountOfClimbers = 0;

    @NotNull
    @ManyToMany
    @JoinTable(name = "tb_group_climbers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id"))
    private List<Climber> climbers = new ArrayList<>();
}
