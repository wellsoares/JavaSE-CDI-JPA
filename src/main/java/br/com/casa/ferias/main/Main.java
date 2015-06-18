package br.com.casa.ferias.main;

import br.com.casa.ferias.controller.CompanyController;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

/**
 * @author well
 */
public class Main {

    public static void main(String[] args) {
//        public void main(@Observes ContainerInitialized event, @Parameters List<String> params) {
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();

        CompanyController userController = BeanProvider.getContextualReference(CompanyController.class, false);

        System.out.println("USUARIOS: " + userController.findAllWhithPurchaseBuyers());

        cdiContainer.shutdown();
    }
}
