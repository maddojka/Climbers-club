package ru.soroko.climbers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
        return namedNativeQuery.getResultList();
    }

    public List<Group> getOpenGoups() {
        TypedQuery<Group> namedNativeQuery = entityManager
                .createNamedQuery("get_open_groups", Group.class);
        return namedNativeQuery.getResultList();
    }

    public List<Ascension> getAscensionsByPeriod() {
        TypedQuery<Ascension> namedNativeQuery = entityManager
                .createNamedQuery("get_ascensions_by_period", Ascension.class);
        return namedNativeQuery.getResultList();
    }
}
