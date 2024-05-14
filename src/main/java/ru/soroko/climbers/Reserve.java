package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_reserves")
public class Reserve {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "group", nullable = false)
    private Group group;

    public Reserve(Group group) {
        if (group == null)
            throw new IllegalArgumentException("Группа не может быть null");
        this.group = group;
    }
}
