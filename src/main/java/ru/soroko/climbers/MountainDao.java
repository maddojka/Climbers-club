package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MountainDao extends Dao<Mountain, Integer> {


    public MountainDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer insert(Mountain mountain) {
        entityManager.getTransaction().begin();
        entityManager.persist(mountain);
        entityManager.getTransaction().commit();
        return mountain.getId();
    }

    @Override
    public void update(Mountain mountain) {
        entityManager.getTransaction().begin();
        entityManager.merge(mountain);
        entityManager.getTransaction().commit();
    }

    @Override
    public Mountain deleteById(Integer integer) {
        Mountain mountain = entityManager.find(Mountain.class, integer);
        entityManager.getTransaction().begin();
        entityManager.remove(mountain);
        entityManager.getTransaction().commit();
        return mountain;
    }

    @Override
    public Mountain findById(Integer integer) {
        return entityManager.find(Mountain.class, integer);
    }

    public List<String> getMountainNames(int succeedClimbers) {
        TypedQuery<String> namedNativeQuery = entityManager
                .createNamedQuery("get_mountain_names", String.class);
        return namedNativeQuery.getResultList();
    }
}
