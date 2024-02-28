package lessons.sixth.shop.dao;

import java.util.List;

public interface GenericDao<T> {

    T getById(Long id);

    boolean delete(Long id);

    List<T> getAll();
}
