package br.com.casa.ferias.dao;

import br.com.casa.ferias.model.Company;
import java.util.List;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

/**
 *
 * @author well
 */
public class CompanyDao extends GenericDAO<Company, Integer> {

    public CompanyDao() {
        super(Company.class);
    }

    @Transactional
    public List<Company> findAllWhithPurchaseBuyers() {
        return manager.createQuery("FROM Company c LEFT JOIN FETCH c.purchaseBuyers").getResultList();
    }

}
