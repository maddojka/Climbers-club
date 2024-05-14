package ru.soroko.climbers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "tb_climbers")
public class Climber {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;
    @Column(name = "phoneNumber", unique = true, nullable = false)
    private long phoneNumber;
    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;
    @Column(name = "last_ascension", nullable = false)
    private LocalDate lastAscension;

    public Climber(String name, String surname, long phoneNumber, String email, LocalDate lastAscension) {
        if ("".equals(name))
            throw new IllegalArgumentException("Имя альпиниста не может быть пустой строкой");
        if ("".equals(surname))
            throw new IllegalArgumentException("Фамилия альпиниста не может быть пустой строкой");
        if (phoneNumber < 0)
            throw new IllegalArgumentException("Номер телефона не может быть отрицательным числом");
        if ("".equals(email))
            throw new IllegalArgumentException("Email альпиниста не может быть пустой строкой");
        if (lastAscension == null)
            throw new IllegalArgumentException("Дата последнего восхождения не может быть пустой");
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.lastAscension = lastAscension;
    }
}
