package br.com.casa.ferias.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

/**
 * @author well
 * @param <T>
 * @param <PK>
 */
@Transactional
public class GenericDAO<T, PK> {

    public final EntityManager manager;

    public GenericDAO(EntityManager manager) {
        this.manager = manager;
    }

    public T getById(PK pk) {
        Object o = manager.find(getTypeClass(), (Serializable) pk);
        return (T) o;
    }

    public void save(T entity) {
        manager.persist(entity);
    }

    public void update(T entity) {
        manager.merge(entity);
    }

    public void delete(T entity) {
        manager.remove(entity);
    }

    public List<T> findAll() {
        List<T> list = manager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
        return list;
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
