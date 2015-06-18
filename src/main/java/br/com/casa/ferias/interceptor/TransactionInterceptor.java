package br.com.casa.ferias.interceptor;

import br.com.casa.ferias.interfaces.TransactionalInterceptor;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 *
 * @author well
 */
@Interceptor
@TransactionalInterceptor
public class TransactionInterceptor {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        System.out.println("Open Transaction");
        em.getTransaction().begin();
        Object resultado = null;
        try {

            resultado = ctx.proceed();
            em.getTransaction().commit();

            System.out.println("COMMIT a Transaction");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("ROLLBACK Transaction");
            e.printStackTrace();
            throw new Exception(e);
        }
        return resultado;
    }
}
