package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AscensionDao
        extends Dao<Ascension, Integer> {


    public AscensionDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer insert(Ascension ascension) {
        entityManager.getTransaction().begin();
        entityManager.persist(ascension);
        entityManager.getTransaction().commit();
        return ascension.getId();
    }

    @Override
    public void update(Ascension ascension) {
        entityManager.getTransaction().begin();
        entityManager.merge(ascension);
        entityManager.getTransaction().commit();
    }

    @Override
    public Ascension deleteById(Integer integer) {
        Ascension ascension = entityManager.find(Ascension.class, integer);
        entityManager.getTransaction().begin();
        entityManager.remove(ascension);
        entityManager.getTransaction().commit();
        return ascension;
    }

    @Override
    public Ascension findById(Integer integer) {
        return entityManager.find(Ascension.class, integer);
    }

    public List<Integer> getGroupId(String superiorData, int succeedClimbers) {
        String getGroupIdSql = "SELECT group_id " +
                "FROM tb_ascensions " +
                "JOIN tb_groups " +
                "ON tb_groups.id = tb_ascensions.group_id " +
                "WHERE tb_groups.superior =:superior " +
                "AND tb_ascensions.succeed_climbers >:succeedClimbers ";
        Query query = entityManager.createNativeQuery(getGroupIdSql, Integer.class);
        query.setParameter("superior", superiorData);
        query.setParameter("succeedClimbers", succeedClimbers);
        return query.getResultList();
    }

    public List<Ascension> getAscensionsByPeriod(LocalDate startDate, LocalDate endDate) {
        String getAscensionsByPeriodSql = "SELECT * " +
                "FROM tb_ascensions " +
                "WHERE start_date >=:startDate " +
                "AND end_date <=:endDate ";
        Query query = entityManager.createNativeQuery(getAscensionsByPeriodSql, Ascension.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public List<String> getMountainNames(int succeedClimbers) {
        String getMountainNamesSql = "SELECT tb_mountains.title " +
                "FROM tb_ascensions " +
                "JOIN tb_mountains " +
                "ON tb_mountains.id = tb_ascensions.mountain_id " +
                "WHERE tb_ascensions.succeed_climbers >:succeedClimbers";
        Query query = entityManager.createNativeQuery(getMountainNamesSql, String.class);
        query.setParameter("succeedClimbers", succeedClimbers);
        return query.getResultList();
    }
}
