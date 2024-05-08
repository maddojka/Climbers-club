package ru.soroko.climbers;

public class Application {
    public static void main(String[] args) {
        Mountain mountain = new Mountain(100);
        AscensionDao ascensionDao = new AscensionDao();
        ascensionDao.createClimber();
        ascensionDao.createMountain();
        ascensionDao.createGroup();
        ascensionDao.createAscension();
    }
}
