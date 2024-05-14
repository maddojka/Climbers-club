package ru.soroko.climbers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

//### Составить SELECT запросы
@org.hibernate.annotations.NamedQueries({
        //Получить фамилии и email альпинистов в отсортированном по фамилии виде, которые не совершали восхождений за последний год.*//*
        @org.hibernate.annotations.NamedQuery(name = "getAscensionSurnamesAndEmails",
                query = "SELECT climber.surname, climber.email " +
                        "FROM  Climber " +
                        "WHERE DATE_PART('day', CURRENT_DATE - 365) < DATE_PART('day', CURRENT_DATE - 365) " +
                        "ORDER BY climber.surname"),
        // По фио руководителя получить идентификаторы групп, где количество покоривших гору больше заданного значения. +
        @org.hibernate.annotations.NamedQuery(name = "getIdByValue",
                query = "SELECT group.id " +
                        "FROM Ascension " +
                        "WHERE group.superior = George Wilson AND succeed_climbers > 2 "),
        // Получить список групп, открытых для записи. +
        @org.hibernate.annotations.NamedQuery(name = "getOpenGroups",
                query = "SELECT group " +
                        "FROM Ascension " +
                        "WHERE group.amount_of_climbers < group.max_climbers " +
                        "AND CURRENT_DATE < group.next_ascension "),
        // Показать список восхождений, которые осуществлялись в заданный период времени. +
        @org.hibernate.annotations.NamedQuery(name = "getAscensionsByPeriod",
                query = "FROM Ascension " +
                        "WHERE start_date >= '2014-02-01' " +
                        "AND end_date < 2014-03-01' "),
        // Показать список названий гор, где количество покоривших гору больше заданного значения. +
        @org.hibernate.annotations.NamedQuery(name = "getMountainNames",
                query = "SELECT title " +
                        "FROM Mountain " +
                        "WHERE ascension.succeed_climbers > 5 "),
})

public class Queries {
    private SessionFactory sessionFactory;

    public List<String> getAscensionSurnamesAndEmails() {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createNamedQuery("getAscensionSurnamesAndEmails", String.class);
            return query.list();
        }
    }


    public List<String> getIdByValue() {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createNamedQuery("getIdByValue", String.class);
            return query.list();
        }
    }


    public List<String> getOpenGroups() {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createNamedQuery("getOpenGroups", String.class);
            return query.list();
        }
    }


    public List<String> getAscensionsByPeriod() {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createNamedQuery("getAscensionsByPeriod", String.class);
            return query.list();
        }
    }

    public List<String> getMountainNames() {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createNamedQuery("getMountainNames", String.class);
            return query.list();
        }
    }
}






