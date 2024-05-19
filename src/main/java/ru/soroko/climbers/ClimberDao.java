package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        Climber competition = entityManager.find(Climber.class, integer);
        entityManager.getTransaction().begin();
        entityManager.remove(competition);
        entityManager.getTransaction().commit();
        return competition;
    }

    @Override
    public Climber findById(Integer integer) {
        return entityManager.find(Climber.class, integer);
    }

    public List<String> getSurnamesAndEmails() {
        String getSurnamesAndEmailsSql = "SELECT surname, email " +
                "FROM tb_climbers " +
                "WHERE DATE_PART('day', last_ascension) < DATE_PART('day', CURRENT_DATE - 365) " +
                "ORDER BY surname ";
        Query query = entityManager.createNativeQuery(getSurnamesAndEmailsSql, String.class);
        return query.getResultList();
    }

}