package DAO;

import java.util.List;

public interface IDAO<T> {
    boolean insert(T object);
    boolean delete(int id);
    T read(int id);
    List<T> getAll();
    void insertAll(List<T> elems);

}
