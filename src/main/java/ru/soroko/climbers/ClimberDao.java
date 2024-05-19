package ru.soroko.climbers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.Query;

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
        TypedQuery<String> namedNativeQuery = entityManager
                .createNamedQuery("get_id_by_value", String.class);
        return namedNativeQuery.getResultList();
    }

}