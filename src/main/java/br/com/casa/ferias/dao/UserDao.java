package br.com.casa.ferias.dao;

import br.com.casa.ferias.model.User;

/**
 *
 * @author well
 */
public class UserDao extends GenericDAO<User, Integer> {

    public UserDao() {
        super(User.class);
    }
}
