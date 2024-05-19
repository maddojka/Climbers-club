package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@NamedNativeQueries({
        @NamedNativeQuery(name = "get_group_id", query = "SELECT group_id " +
                "FROM tb_ascensions " +
                "JOIN tb_groups " +
                "ON tb_groups.id = tb_ascensions.group_id " +
                "WHERE tb_groups.superior =:superior AND tb_ascensions.succeed_climbers >:succeedClimbers "),
        @NamedNativeQuery(name = "get_ascensions_by_period", query = "SELECT * " +
                "FROM tb_ascensions " +
                "WHERE start_date >=:startDate " +
                "AND end_date <:=endDate "),
        @NamedNativeQuery(name = "get_mountain_names", query = "SELECT tb_mountains.title " +
                "FROM tb_ascensions " +
                "JOIN tb_mountains " +
                "ON tb_mountains.id = tb_ascensions.mountain_id " +
                "WHERE tb_ascensions.succeed_climbers >:succeedClimbers ")
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "mountain_id", nullable = false)
    private Mountain mountain;

}
