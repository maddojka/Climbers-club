package ru.soroko.climbers;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Group {
    private long id;
    private Mountain mountain;
    private String superior;
    private LocalDate nextAscension;
    private int maxClimbers;
    private double cost;


}
