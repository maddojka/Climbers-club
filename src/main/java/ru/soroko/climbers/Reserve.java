package ru.soroko.climbers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToMany
    @JoinTable(name = "tb_reserve_climbers",
            joinColumns = @JoinColumn(name = "reserve_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id"))
    private List<Climber> climbers = new ArrayList<>();

}
