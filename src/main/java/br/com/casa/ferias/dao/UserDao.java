package br.com.casa.ferias.dao;

import br.com.casa.ferias.model.User;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

/**
 *
 * @author well
 */
public class UserDao extends GenericDAO<User, Integer> {

    @Inject
    public UserDao(EntityManager manager) {
        super(manager);
    }

}
