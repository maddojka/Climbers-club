package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
        TypedQuery<Integer> namedNativeQuery = entityManager
                .createNamedQuery("get_group_id", Integer.class);
        namedNativeQuery.setParameter("superior", superiorData);
        namedNativeQuery.setParameter("succeedClimbers", succeedClimbers);
        return namedNativeQuery.getResultList();
    }

    public List<Ascension> getAscensionsByPeriod(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Ascension> namedNativeQuery = entityManager
                .createNamedQuery("get_ascensions_by_period", Ascension.class);
        namedNativeQuery.setParameter("startDate", startDate);
        namedNativeQuery.setParameter("endDate", endDate);
        return namedNativeQuery.getResultList();
    }

    public List<String> getMountainNames(int succeedClimbers) {
        TypedQuery<String> namedNativeQuery = entityManager
                .createNamedQuery("get_mountain_names", String.class);
        namedNativeQuery.setParameter("succeedClimbers", succeedClimbers);
        return namedNativeQuery.getResultList();
    }
}
