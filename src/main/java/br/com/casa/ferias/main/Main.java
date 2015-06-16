package br.com.casa.ferias.main;

import br.com.casa.ferias.controller.UserController;
import br.com.casa.ferias.model.User;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

/**
 *
 * @author well
 */
public class Main {

    public static void main(String[] args) {
//        public void main(@Observes ContainerInitialized event, @Parameters List<String> params) {
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        UserController userController = BeanProvider.getContextualReference(UserController.class, false);

        User u = new User();

        u.setName("Wellington");
        u.setCpf("qwewqeqwe");
        u.setEmail("well_002@yahoo.com.br");
        u.setLastName("Nunes");
        u.setPassword("4512345679");

        userController.saveUser(u);

        cdiContainer.shutdown();
    }
}
