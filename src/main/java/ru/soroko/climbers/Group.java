package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "tb_groups")
public class Group {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "mountain_id", nullable = false)
    private Mountain mountain;
    @Column(name = "superior", nullable = false, length = 100)
    private String superior;
    @Column(name = "next_ascension", nullable = false)
    private LocalDate nextAscension;
    @Column(name = "max_climbers", nullable = false)
    private int maxClimbers;
    @Column(name = "cost", nullable = false)
    private double cost;
    @Column(name = "amount_of_climbers", nullable = false)
    private int amountOfClimbers;

    public Group(String superior, LocalDate nextAscension, int maxClimbers, double cost) {
        if ("".equals(superior))
            throw new IllegalArgumentException("ФИО руководителя группы не может быть пустой строкой");
        if (nextAscension == null)
            throw new IllegalArgumentException("Дата следующего восхождения не может быть пустой");
        if (maxClimbers <= 0)
            throw new IllegalArgumentException("Максимальное количество альпиниство " +
                    "в группе должно быть положительным числом");
        if (cost < 1000.0)
            throw new IllegalArgumentException("Стоимость участия должна быть больше или равна 1000");
        this.superior = superior;
        this.nextAscension = nextAscension;
        this.maxClimbers = maxClimbers;
        this.cost = cost;
    }
}
