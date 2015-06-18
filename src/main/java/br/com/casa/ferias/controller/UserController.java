package br.com.casa.ferias.controller;

import br.com.casa.ferias.dao.UserDao;
import br.com.casa.ferias.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author well
 */
public class UserController {

    @Inject
    private UserDao uDao;

    public void saveUser(User u) {
        uDao.save(u);
    }

    public List<User> findAll() {
        return uDao.findAll();
    }

    public User getById(Integer id) {
        return uDao.getById(id);
    }
}
