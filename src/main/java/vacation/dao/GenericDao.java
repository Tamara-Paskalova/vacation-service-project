package vacation.dao;

public interface GenericDao<T> {
    T add(T entity);

    T update(T entity);
}
