package br.com.casa.ferias.conf;

import java.io.Serializable;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author well
 */
public class EntityManagerProducer implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "white-dragon")
    private EntityManager entityManager;

    @Produces
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("white-dragon").createEntityManager();
    }
//    @Produces
//    public EntityManager entityManager() {
//        return Persistence.createEntityManagerFactory("white-dragon").createEntityManager();
//    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
            System.out.println("FECHOU ENTITY MANAGER !!!!");
        }
    }
}
