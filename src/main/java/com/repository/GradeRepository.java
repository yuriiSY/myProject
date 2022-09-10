package com.repository;

import com.config.HibernateFactoryUtil;
import com.impl.CrudRepository;
import com.model.Grade;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GradeRepository implements CrudRepository<Grade> {
    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();

    private static GradeRepository instance;

    public static GradeRepository getInstance() {
        if (instance == null) {
            instance = new GradeRepository();
        }
        return instance;
    }
    @Override
    public void save(Grade entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Grade> entitys) {
        entityManager.getTransaction().begin();
        for (Grade entity : entitys) {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Grade entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Grade.class,id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Grade> getAll() {
        return entityManager.createQuery("SELECT s FROM Grade s", Grade.class).getResultList();
    }

    public Map<String,Double> findMoreThan(double mark) {
       Map<String,Double> map = new HashMap<>();
       List<Object> list =  entityManager.createQuery("select g.student.id, avg(g.signification) from Grade g " +
                        "LEFT JOIN Student s ON s.id = g.student.id GROUP BY g.student.id HAVING avg(g.signification)>:mark")
                .setParameter("mark",mark)
                .getResultList();
        list.forEach(pair -> {
            Object[] objects = (Object[]) pair;
            map.put((String) objects[0], (Double)objects[1]);
        });
        return map;
    }

    @Override
    public Optional<Grade> findById(String id) {
        return Optional.ofNullable(entityManager.find(Grade.class, id));
    }

    //    @Override
//    public Optional<Television> findByName(String title) {
//        return Optional.ofNullable(entityManager.find(Television.class, title));
//    }
}
//    SELECT avg(signification), student_id
//FROM public."Grade"
//        Left JOIN public."Student" USING(id)
//        GROUP BY
//        student_id
//        HAVING AVG (signification) > 2