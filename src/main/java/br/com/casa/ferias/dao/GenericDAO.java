package br.com.casa.ferias.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

/**
 * @author well
 * @param <T>
 * @param <PK>
 */
@Transactional
public class GenericDAO<T, PK> {

    @Inject
    public EntityManager manager;
    private final Class persistentClass;

    public GenericDAO(Class c) {
        persistentClass = c;
    }

    public T getById(PK pk) {
        Object o = manager.find(persistentClass, (Serializable) pk);
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
        List<T> list = manager.createQuery(("FROM " + persistentClass.getName())).getResultList();
        return list;
    }
}
