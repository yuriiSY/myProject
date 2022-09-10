package com.repository;

import com.config.HibernateFactoryUtil;
import com.impl.CrudRepository;
import com.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements CrudRepository<Student> {

    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();

    private static StudentRepository instance;

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    @Override
    public void save(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Student> entitys) {
        entityManager.getTransaction().begin();
        for (Student entity : entitys) {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Student.class,id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> getAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }


}
