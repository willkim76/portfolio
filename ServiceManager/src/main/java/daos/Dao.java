package daos;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Defines the CRUD behavior for ServiceManager data access objects
 * @param <T> The type parsed between the service layer and the persistent layer
 */
public interface Dao<T> {

    List<T> getAll() throws Exception;

    T get(String id) throws Exception;

    void save(T t) throws Exception;

    boolean update(T t, String[] params) throws Exception;

    boolean delete(T t) throws Exception;
}
