package ru.soroko.climbers;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Country tanzania = new Country("Tanzania");
        Mountain kilimanjaro = new Mountain("Kilimanjaro", tanzania, 5895);
        Country russia = new Country("Russia");
        Mountain elbrus = new Mountain("Elbrus", russia, 5643);
        Country argentina = new Country("Argentina");
        Mountain andes = new Mountain("Andes", argentina, 6961);
        Climber firstClimber =
                new Climber("Adam", "Smith", 892113374563L, "asmith@gmail.com",
                        LocalDate.of(2022, 4, 30));
        Climber secondClimber =
                new Climber("Samuel", "Adamson", 892187374572L, "sadamson@gmail.com",
                        LocalDate.of(2021, 9, 10));
        Climber thirdClimber =
                new Climber("Olivia", "Smith", 891178855541L, "osmith@gmail.com",
                        LocalDate.of(2018, 6, 12));
        Climber fourthClimber =
                new Climber("Jack", "Aldridge", 893144579005L, "jaldridge@gmail.com",
                        LocalDate.of(2023, 12, 5));
        Climber fifthClimber =
                new Climber("Amelia", "Brown", 892115576522L, "abrown@gmail.com",
                        LocalDate.of(2022, 8, 15));
        Climber sixthClimber =
                new Climber("Joseph", "Evans", 891187674552L, "jevans@gmail.com",
                        LocalDate.of(2020, 5, 10));
        Climber seventhClimber =
                new Climber("Emily", "Walker", 899923377764L, "ewalker@gmail.com",
                        LocalDate.of(2019, 6, 17));
        Climber eighthClimber =
                new Climber("Harry", "Johnson", 8952323675567L, "hjohnson@gmail.com",
                        LocalDate.of(2023, 11, 13));
        Climber ninethClimber =
                new Climber("Jessica", "Harris", 891114479591L, "jharris@gmail.com",
                        LocalDate.of(2024, 2, 20));
        Climber tenthClimber =
                new Climber("Thomas", "Davies", 892113074483L, "tdavies@gmail.com",
                        LocalDate.of(2024, 3, 31));
        Group firstGroup =
                new Group("George Wilson", LocalDate.of(2024, 8, 6), 10, 5000);
        Group secondGroup =
                new Group("Lily King", LocalDate.of(2024, 10, 15), 6, 3500);
        Group thirdGroup =
                new Group("Connor Ellington", LocalDate.of(2024, 8, 25), 5, 4000);
        Ascension kilimanjaroAscension =
                new Ascension(LocalDate.of(2023, 8, 6),
                        LocalDate.of(2023, 9, 10), 5);
        Ascension elbrusAscension =
                new Ascension(LocalDate.of(2022, 10, 15),
                        LocalDate.of(2022, 11, 6), 10);
        Ascension andesAscension =
                new Ascension(LocalDate.of(2021, 5, 6),
                        LocalDate.of(2021, 6, 6), 4);
        AscensionDao ascensionDao = new AscensionDao();
        Queries queries = new Queries();
        ascensionDao.createClimber();
        ascensionDao.createMountain();
        ascensionDao.createGroup();
        ascensionDao.createAscension();
       // insertSql(elbrus);
    }

//    public static <T> int insertSql(T t) {
//        return session.persist(t);
//    }
}
