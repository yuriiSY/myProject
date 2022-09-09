package impl;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    void save(T entity);

    void saveAll(List<T> entity);

    void update(T entity);

    void delete(String id);

    List<T> getAll();

    Optional<T> findById(String id);
}
