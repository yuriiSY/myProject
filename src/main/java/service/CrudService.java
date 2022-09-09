package service;

import java.util.List;

public interface CrudService<T> {
     void save(T entity);
     void delete(String id);
     void update(T entity);
    void printAll();
    List<T> getAll();
}
