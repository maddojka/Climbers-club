package ru.soroko.climbers;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("climbers");
        EntityManager manager = factory.createEntityManager();
        // creating dao
        AscensionDao ascensionDao = new AscensionDao(manager);
        ClimberDao climberDao = new ClimberDao(manager);
        CountryDao countryDao = new CountryDao(manager);
        GroupDao groupDao = new GroupDao(manager);
        MountainDao mountainDao = new MountainDao(manager);
        ReserveDao reserveDao = new ReserveDao(manager);
        // creating climbers
        // first climber
        Climber firstClimber =
                new Climber();
        firstClimber.setName("Adam");
        firstClimber.setSurname("Smith");
        firstClimber.setPhoneNumber(892113374563L);
        firstClimber.setEmail("asmith@gmail.com");
        firstClimber.setLastAscension(LocalDate.of(2022, 4, 30));
        climberDao.insert(firstClimber);
        Climber secondClimber = new Climber();
        // second climber
        secondClimber.setName("Samuel");
        secondClimber.setSurname("Adamson");
        secondClimber.setPhoneNumber(892187374572L);
        secondClimber.setEmail("sadamson@gmail.com");
        secondClimber.setLastAscension(LocalDate.of(2021, 9, 10));
        climberDao.insert(secondClimber);
        // third climber
        Climber thirdClimber = new Climber();
        thirdClimber.setName("Olivia");
        thirdClimber.setSurname("Smith");
        thirdClimber.setPhoneNumber(891178855541L);
        thirdClimber.setEmail("osmith@gmail.com");
        thirdClimber.setLastAscension(LocalDate.of(2018, 6, 12));
        climberDao.insert(thirdClimber);
        // fourth climber
        Climber fourthClimber = new Climber();
        fourthClimber.setName("Jack");
        fourthClimber.setSurname("Aldridge");
        fourthClimber.setPhoneNumber(893144579005L);
        fourthClimber.setEmail("jaldridge@gmail.com");
        fourthClimber.setLastAscension(LocalDate.of(2023, 12, 5));
        climberDao.insert(fourthClimber);
        // fifth climber
        Climber fifthClimber = new Climber();
        fifthClimber.setName("Amelia");
        fifthClimber.setSurname("Brown");
        fifthClimber.setPhoneNumber(892115576522L);
        fifthClimber.setEmail("abrown@gmail.com");
        fifthClimber.setLastAscension(LocalDate.of(2022, 8, 15));
        climberDao.insert(fifthClimber);
        // sixth climber
        Climber sixthClimber = new Climber();
        sixthClimber.setName("Joseph");
        sixthClimber.setSurname("Evans");
        sixthClimber.setPhoneNumber(891187674552L);
        sixthClimber.setEmail("jevans@gmail.com");
        sixthClimber.setLastAscension(LocalDate.of(2020, 5, 10));
        climberDao.insert(sixthClimber);
        // seventh climber
        Climber seventhClimber = new Climber();
        seventhClimber.setName("Emily");
        seventhClimber.setSurname("Walker");
        seventhClimber.setPhoneNumber(899923377764L);
        seventhClimber.setEmail("ewalker@gmail.com");
        seventhClimber.setLastAscension(LocalDate.of(2019, 6, 17));
        climberDao.insert(seventhClimber);
        // eighth climber
        Climber eighthClimber = new Climber();
        eighthClimber.setName("Harry");
        eighthClimber.setSurname("Johnson");
        eighthClimber.setPhoneNumber(8952323675567L);
        eighthClimber.setEmail("hjohnson@gmail.com");
        eighthClimber.setLastAscension(LocalDate.of(2023, 11, 13));
        climberDao.insert(eighthClimber);
        // nineth climber
        Climber ninethClimber = new Climber();
        ninethClimber.setName("Jessica");
        ninethClimber.setSurname("Harris");
        ninethClimber.setPhoneNumber(891114479591L);
        ninethClimber.setEmail("jharris@gmail.com");
        ninethClimber.setLastAscension(LocalDate.of(2024, 2, 20));
        climberDao.insert(ninethClimber);
        // tenth climber
        Climber tenthClimber = new Climber();
        tenthClimber.setName("Thomas");
        tenthClimber.setSurname("Davies");
        tenthClimber.setPhoneNumber(892113074483L);
        tenthClimber.setEmail("tdavies@gmail.com");
        tenthClimber.setLastAscension(LocalDate.of(2024, 3, 31));
        climberDao.insert(tenthClimber);
        // creating countries
        // tanzania
        Country tanzania = new Country();
        tanzania.setName("Tanzania");
        countryDao.insert(tanzania);
        // russia
        Country russia = new Country();
        russia.setName("Russia");
        countryDao.insert(russia);
        // argentina
        Country argentina = new Country();
        argentina.setName("Argentina");
        countryDao.insert(argentina);
        // chile
        Country chile = new Country();
        chile.setName("Chile");
        countryDao.insert(chile);
        // creating mountains
        Mountain kilimanjaro = new Mountain();
        kilimanjaro.setTitle("Kilimanjaro");
        kilimanjaro.setHeight(5895);
        mountainDao.insert(kilimanjaro);
        Mountain elbrus = new Mountain();
        elbrus.setTitle("Elbrus");
        elbrus.setHeight(5643);
        mountainDao.insert(elbrus);
        Mountain andes = new Mountain();
        andes.setTitle("Andes");
        andes.setHeight(6961);
        mountainDao.insert(andes);
        // creating groups
        Group firstGroup = new Group();
        firstGroup.setMountain(kilimanjaro);
        firstGroup.setSuperior("George Wilson");
        firstGroup.setNextAscension(LocalDate.of(2024, 8, 6));
        firstGroup.setMaxClimbers(10);
        firstGroup.setCost(5000.0);
        groupDao.insert(firstGroup);
        Group secondGroup = new Group();
        secondGroup.setMountain(elbrus);
        secondGroup.setSuperior("Lily King");
        secondGroup.setNextAscension(LocalDate.of(2024, 10, 15));
        secondGroup.setMaxClimbers(6);
        secondGroup.setCost(3500.0);
        groupDao.insert(secondGroup);
        Group thirdGroup = new Group();
        thirdGroup.setMountain(andes);
        thirdGroup.setSuperior("Connor Ellington");
        thirdGroup.setNextAscension(LocalDate.of(2024, 8, 25));
        thirdGroup.setMaxClimbers(5);
        thirdGroup.setCost(4000.0);
        groupDao.insert(thirdGroup);
        // creating ascensions
        Ascension kilimanjaroAscension = new Ascension();
        kilimanjaroAscension.setStartDate(LocalDate.of(2023, 8, 6));
        kilimanjaroAscension.setEndDate(LocalDate.of(2023, 9, 10));
        kilimanjaroAscension.setSucceedClimbers(5);
        kilimanjaroAscension.setGroup(firstGroup);
        kilimanjaroAscension.setMountain(kilimanjaro);
        ascensionDao.insert(kilimanjaroAscension);
        Ascension elbrusAscension = new Ascension();
        elbrusAscension.setStartDate(LocalDate.of(2022, 10, 15));
        elbrusAscension.setEndDate(LocalDate.of(2022, 11, 6));
        elbrusAscension.setSucceedClimbers(10);
        elbrusAscension.setGroup(secondGroup);
        elbrusAscension.setMountain(elbrus);
        ascensionDao.insert(elbrusAscension);
        Ascension andesAscension = new Ascension();
        andesAscension.setStartDate(LocalDate.of(2021, 5, 6));
        andesAscension.setEndDate(LocalDate.of(2021, 6, 6));
        andesAscension.setSucceedClimbers(4);
        andesAscension.setGroup(thirdGroup);
        andesAscension.setMountain(andes);
        ascensionDao.insert(andesAscension);
        // creating reserve group
        Reserve reserve = new Reserve();
        // call queries
        climberDao.getSurnamesAndEmails();
        ascensionDao.getOpenGoups();
        ascensionDao.getGroupId("George Wilson", 5);
        ascensionDao.getAscensionsByPeriod(LocalDate.of(2021, 5, 6),
                LocalDate.of(2023, 9, 10));
        mountainDao.getMountainNames(5);
        // add climber
        addClimber(fifthClimber, firstGroup, reserve, climberDao);
        manager.close();
        factory.close();
    }

    public static void addClimber(Climber climber, Group group, Reserve reserve, ClimberDao climberDao) {
        if (climber == null || group == null
                || climberDao == null || reserve == null) return;
        if (group.getAmountOfClimbers() < group.getMaxClimbers()) {
            climber.getGroups().add(group);
            climberDao.insert(climber);
            group.setAmountOfClimbers(+1);
        } else {
            climber.getReserveGroups().add(reserve);
            climberDao.insert(climber);
        }
    }
}
