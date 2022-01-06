package daos;

import java.util.List;

/**
 * Defines the CRUD behavior for ServiceManager data access objects
 * @param <T> The type parsed between the service layer and the persistent layer
 */
public interface Dao<T> {

    List<T> getAll();

    T get(String id);

    void save(T t);

    boolean update(T t, String[] params);

    boolean delete(T t);
}
