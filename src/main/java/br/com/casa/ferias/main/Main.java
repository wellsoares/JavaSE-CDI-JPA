package br.com.casa.ferias.main;

import br.com.casa.ferias.dao.UserDao;
import br.com.casa.ferias.model.User;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import java.util.List;
import org.jboss.weld.environment.se.bindings.Parameters;

/**
 *
 * @author well
 */
public class Main {

    @Inject
    UserDao uDao;

    public void main(@Observes ContainerInitialized event, @Parameters List<String> params) {

        User u = new User();

        u.setName("Wellington");
        u.setCpf("38417525866");
        u.setEmail("well_002@yahoo.com.br");
        u.setLastName("Nunes");
        u.setPassword("4512345679");

        uDao.save(u);

    }
}
