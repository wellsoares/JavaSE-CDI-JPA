package br.com.casa.ferias.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author well
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(sequenceName = "seq_company", allocationSize = 20, name = "id")
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "company_name", nullable = false, length = 40)
    private String companyName;
    @Column(name = "commercial_name", nullable = false, length = 30)
    private String commercialName;
    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;
    @Column(length = 20)
    private String profile;
    @Column(length = 30)
    private String phone;
    @Column(name = "zip_code", length = 9)
    private String zipCode;
    @Column(length = 30)
    private String street;
    @Column(length = 20)
    private String city;
    @Column(name = "province", length = 20)
    private String province;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<PurchaseBuyer> purchaseBuyers;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", companyName=" + companyName + ", purchaseBuyers=" + purchaseBuyers + '}';
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<PurchaseBuyer> getPurchaseBuyers() {
        return purchaseBuyers;
    }

    public void setPurchaseBuyers(List<PurchaseBuyer> purchaseBuyers) {
        this.purchaseBuyers = purchaseBuyers;
    }
}
