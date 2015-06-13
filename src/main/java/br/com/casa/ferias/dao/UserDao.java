package br.com.casa.ferias.dao;

import br.com.casa.ferias.interfaces.Transactional;
import br.com.casa.ferias.model.User;
import javax.persistence.EntityManager;

/**
 *
 * @author well
 */
public class UserDao extends GenericDAO<User, Integer> {

    public UserDao(EntityManager manager) {
        super(manager);
    }

    @Override
    @Transactional
    public void save(User u) {
        manager.persist(u);
    }

}
