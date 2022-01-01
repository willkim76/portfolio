package daos;

import java.util.List;

/**
 * Defines the CRUD behavior for data access objects to implement
 * @param <T> The type parsed between the service layer and the persistent layer
 */
public interface Dao<T> {

    List<T> getAll();

    T get(String id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
