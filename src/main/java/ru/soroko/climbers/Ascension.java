package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@NamedNativeQueries({
        @NamedNativeQuery(name = "get_group_id", query = "SELECT group.id " +
                "FROM tb_ascensions " +
                "JOIN tb_groups " +
                "ON tb_groups.id = tb_ascensions.group_id " +
                "WHERE group.superior = George Wilson AND succeed_climbers > 2 "),
        @NamedNativeQuery(name = "get_open_groups", query = "SELECT tb_groups.id " +
                "FROM tb_ascensions " +
                "JOIN tb_groups " +
                "ON tb_groups.id = tb_ascensions.group_id " +
                "WHERE tb_groups.superior = ? AND tb_groups.succeed_climbers > ? "),
        @NamedNativeQuery(name = "get_ascensions_by_period", query = "SELECT * " +
                "FROM tb_ascensions " +
                "WHERE start_date >= '2014-02-01' " +
                "AND end_date < 2014-03-01' ")
})
@Data
@Entity
@Table(name = "tb_ascensions")
public class Ascension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @PositiveOrZero
    @Column(name = "succeed_climbers", nullable = false)
    private int succeedClimbers;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

}
