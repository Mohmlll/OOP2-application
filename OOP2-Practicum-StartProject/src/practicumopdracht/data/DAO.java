package practicumopdracht.data;


import java.util.List;

/**
 * @author Mohammed Malloul
 */

public interface DAO<T> {

    List<T> getAll();

    void addOrUpdate(T object);

    void remove(T object);

    boolean save();

    boolean load();

}
