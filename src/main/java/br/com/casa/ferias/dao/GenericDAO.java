package br.com.casa.ferias.dao;

import br.com.casa.ferias.interfaces.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author well
 * @param <T>
 * @param <PK>
 */
public class GenericDAO<T, PK> {

    public final EntityManager manager;


    public GenericDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    public T getById(PK pk) {
        Object o = manager.find(getTypeClass(), (Serializable) pk);
        return (T) o;
    }

    @Transactional
    public void save(T entity) {
        manager.persist(entity);
    }

    @Transactional
    public void update(T entity) {
        manager.merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        manager.remove(entity);
    }

    @Transactional
    public List<T> findAll() {
        List<T> list = manager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
        return list;
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
