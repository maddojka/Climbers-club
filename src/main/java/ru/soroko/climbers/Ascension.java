package ru.soroko.climbers;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Ascension {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int succeedClimbers;
    private Group group;
}
