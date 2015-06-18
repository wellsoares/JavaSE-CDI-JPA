package br.com.casa.ferias.conf;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

/**
 *
 * @author well
 */
@ApplicationScoped
public class EntityManagerProducer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManagerFactory factory;

    @Produces
    private EntityManagerFactory createFactory() {
        return Persistence.createEntityManagerFactory("white-dragon");
    }

    @Produces
    @TransactionScoped
    public EntityManager createEntityManager() {
        return factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
            System.out.println("FECHOU MANAGER !!!");
        }
        System.out.println("asdsads !!!");
    }

//    public void closeEntityManager(@Disposes EntityManagerFactory factory) {
//        if (factory.isOpen()) {
//            factory.close();
//            System.out.println("FECHOU FACTORY !!!");
//        }
//    }
}
