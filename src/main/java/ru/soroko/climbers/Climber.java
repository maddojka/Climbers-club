package ru.soroko.climbers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Climber {
    private long id;
    private String name;
    private String surname;
    private int phoneNumber; //unique
    private String email;
}
