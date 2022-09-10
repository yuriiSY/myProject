package com.repository;

import com.config.HibernateFactoryUtil;
import com.impl.CrudRepository;
import com.model.Teacher;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TeacherRepository implements CrudRepository<Teacher> {
    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();

    private static TeacherRepository instance;

    public static TeacherRepository getInstance() {
        if (instance == null) {
            instance = new TeacherRepository();
        }
        return instance;
    }

    @Override
    public void save(Teacher entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Teacher> entitys) {
        entityManager.getTransaction().begin();
        for (Teacher entity : entitys) {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Teacher entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Teacher.class,id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Teacher> getAll() {
        return entityManager.createQuery("SELECT s FROM Teacher s", Teacher.class).getResultList();
    }

    @Override
    public Optional<Teacher> findById(String id) {
        return Optional.ofNullable(entityManager.find(Teacher.class, id));
    }

    public List<Teacher> findTeacher(String name, String surname) {
     return entityManager.createQuery("SELECT t FROM Teacher t WHERE t.name = :name OR t.surname = :surname",Teacher.class)
                .setParameter("name",name)
                .setParameter("surname",surname)
                .getResultList();
    }
}
