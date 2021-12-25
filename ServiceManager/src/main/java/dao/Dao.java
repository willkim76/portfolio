package dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T get(String id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
