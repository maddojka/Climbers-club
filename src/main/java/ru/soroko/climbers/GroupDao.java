package ru.soroko.climbers;

import jakarta.persistence.EntityManager;

public class GroupDao
        extends Dao<Group, Integer> {


    public GroupDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Integer insert(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        return group.getId();
    }

    @Override
    public void update(Group group) {
        entityManager.getTransaction().begin();
        entityManager.merge(group);
        entityManager.getTransaction().commit();
    }

    @Override
    public Group deleteById(Integer integer) {
        Group group = entityManager.find(Group.class, integer);
        entityManager.getTransaction().begin();
        entityManager.remove(group);
        entityManager.getTransaction().commit();
        return group;
    }

    @Override
    public Group findById(Integer integer) {
        return entityManager.find(Group.class, integer);
    }
}
