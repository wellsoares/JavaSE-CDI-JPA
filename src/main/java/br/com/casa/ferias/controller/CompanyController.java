package br.com.casa.ferias.controller;

import br.com.casa.ferias.dao.CompanyDao;
import br.com.casa.ferias.model.Company;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author well
 */
public class CompanyController {

    @Inject
    private CompanyDao companyDao;

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    public List<Company> findAllWhithPurchaseBuyers() {
        return companyDao.findAllWhithPurchaseBuyers();
    }

}
