package dao;

import java.util.List;

/**
 * CRUD behavior for daos to implement
 * @param <T>
 */
public interface Dao<T> {

    List<T> getAll();

    T get(String id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
