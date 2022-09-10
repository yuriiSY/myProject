package com.repository;

import com.config.HibernateFactoryUtil;
import com.impl.CrudRepository;
import com.model.Subject;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SubjectRepository implements CrudRepository<Subject> {
    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();

    private static SubjectRepository instance;

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }

    @Override
    public void save(Subject entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Subject> entitys) {
        entityManager.getTransaction().begin();
        for (Subject entity : entitys) {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Subject entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Subject.class,id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Subject> getAll() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    @Override
    public Optional<Subject> findById(String id) {
        return Optional.ofNullable(entityManager.find(Subject.class, id));
    }

    public Map<String,Double> worstSubject() {
        List<Object[]> list = entityManager.createQuery("SELECT s.id, AVG(g.signification) from Subject s " +
                "LEFT JOIN Grade g ON s.id = g.subject.id GROUP BY s.id ORDER BY AVG(g.signification) asc").getResultList();
        Object[] objects = list.get(0);
        return Map.of((String) objects[0], (Double)objects[1]);
    }
    public Map<String,Double> bestSubject() {
        List<Object[]> list = entityManager.createQuery("SELECT s.id, AVG(g.signification) from Subject s " +
                "LEFT JOIN Grade g ON s.id = g.subject.id GROUP BY s.id ORDER BY AVG(g.signification) desc").getResultList();
        Object[] objects = list.get(0);
        return Map.of((String) objects[0], (Double)objects[1]);
    }
}
//
//SELECT public."Subject".id, public."Grade".signification
//        FROM public."Subject"
//        Full JOIN public."Grade"
//        ON public."Subject".id = public."Grade".subject_id
//        Order by public."Grade".signification asc