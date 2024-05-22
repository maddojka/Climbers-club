package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

import java.util.List;

public class ClimberDao
        extends Dao<Climber, Integer> {

    public ClimberDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer insert(Climber climber) {
        entityManager.getTransaction().begin();
        entityManager.persist(climber);
        entityManager.getTransaction().commit();
        return climber.getId();
    }

    @Override
    public void update(Climber climber) {
        entityManager.getTransaction().begin();
        entityManager.merge(climber);
        entityManager.getTransaction().commit();
    }

    @Override
    public Climber deleteById(Integer integer) {
        Climber climber = entityManager.find(Climber.class, integer);
        entityManager.getTransaction().begin();
        entityManager.remove(climber);
        entityManager.getTransaction().commit();
        return climber;
    }

    @Override
    public Climber findById(Integer integer) {
        return entityManager.find(Climber.class, integer);
    }

    public List<Tuple> getSurnamesAndEmails() {
        String getSurnamesAndEmailsSql = "SELECT surname, email " +
                "FROM tb_climbers " +
                "WHERE last_ascension < CURRENT_DATE - 365 " +
                "ORDER BY surname ";
        Query query = entityManager.createNativeQuery(getSurnamesAndEmailsSql, Tuple.class);
        return query.getResultList();
    }
}