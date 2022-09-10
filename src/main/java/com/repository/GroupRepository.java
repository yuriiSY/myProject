package com.repository;

import com.config.HibernateFactoryUtil;
import com.impl.CrudRepository;
import com.model.Group;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupRepository implements CrudRepository<Group> {
    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();

    private static GroupRepository instance;

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }
    @Override
    public void save(Group entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Group> entitys) {
        entityManager.getTransaction().begin();
        for (Group entity : entitys) {
            entityManager.persist(entity);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Group entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Group.class,id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Group> getAll() {
        return entityManager.createQuery("SELECT s FROM Group s", Group.class).getResultList();
    }


    public List<Group> getByName(String nameOfGroup) {
        return  entityManager.createQuery("SELECT g FROM Group g where g.nameOfGroup like :nameOfGroup", Group.class)
                .setParameter("nameOfGroup", "%" + nameOfGroup + "%")
                .getResultList();
    }

    @Override
    public Optional<Group> findById(String id) {
        return Optional.ofNullable(entityManager.find(Group.class, id));
    }

    public Map<String, Long> groupBySum() {
        Map<String, Long> students = new HashMap<>();
        List<Object> list = entityManager.createQuery("SELECT s.group.nameOfGroup, count(s.id) from Student s group by s.group.nameOfGroup").getResultList();
        list.forEach(pair -> {
            Object[] objects = (Object[]) pair;
            students.put((String) objects[0], (Long) objects[1]);
        });
        return students;
    }

    public Map<String, Double> groupByAvgMarks() {
        Map<String, Double> students = new HashMap<>();
        List<Object> list = entityManager.createQuery(" SELECT g.nameOfGroup, avg(m.signification) From Group g " +
                "LEFT JOIN Student s ON g.id = s.group.id " +
                "LEFT JOIN Grade m ON s.id = m.student.id " +
                "GROUP BY g.nameOfGroup").getResultList();
        list.forEach(pair -> {
            Object[] objects = (Object[]) pair;
            students.put((String) objects[0], (Double) objects[1]);
        });
        return students;
    }
}

//SELECT public."Group"."nameOfGroup" as group_name, AVG(public."Grade".signification)
//        FROM public."Group"
//        Left JOIN public."Student"
//        ON public."Group".id = public."Student".group_id
//        Left Join public."Grade"
//        ON public."Student".id = public."Grade".student_id
//        Group by group_name