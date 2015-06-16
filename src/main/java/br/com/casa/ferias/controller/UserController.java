package br.com.casa.ferias.controller;

import br.com.casa.ferias.dao.UserDao;
import br.com.casa.ferias.model.User;
import javax.inject.Inject;

/**
 *
 * @author well
 */

public class UserController {

    public UserController() {
    }

    @Inject
    UserDao uDao;

    public void saveUser(User u) {
        uDao.save(u);
    }
}
