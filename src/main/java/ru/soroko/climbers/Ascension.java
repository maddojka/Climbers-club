package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "tb_ascensions")
public class Ascension {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "succeed_climbers", nullable = false)
    private int succeedClimbers;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Ascension(LocalDate startDate, LocalDate endDate, int succeedClimbers) {
        if (startDate == null)
            throw new IllegalArgumentException("Дата начала восхождения не может быть пустым");
        if (endDate == null)
            throw new IllegalArgumentException("Дата окончания восхождения не может быть пустым");
        if (succeedClimbers < 0)
            throw  new IllegalArgumentException("Количество покоривших гору не может быть отрицательным числом");
        this.startDate = startDate;
        this.endDate = endDate;
        this.succeedClimbers = succeedClimbers;
    }
}
