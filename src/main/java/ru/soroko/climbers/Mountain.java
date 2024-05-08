package ru.soroko.climbers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Mountain {
    private long id;
    private String title;
    private List<String> country;
    private int height;

    public Mountain(int height) {
        if (height < 100)
            throw new IllegalArgumentException("Высота горы не может быть меньше 100 м");
        this.height = height;
    }
}
