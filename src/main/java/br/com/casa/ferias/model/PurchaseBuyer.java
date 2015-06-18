package br.com.casa.ferias.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author well
 */
@Entity
@Table(name = "purchase_buyer")
public class PurchaseBuyer implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(sequenceName = "seq_purchase_buyer", allocationSize = 20, name = "id")
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 30)
    private String title;

    @Column(name = "payment_method", length = 15)
    private String paymentMethod;
    @Column(name = "delivery_time", length = 4)
    private Integer deliveryTime;
    @Column(length = 400, name = "detail")
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @Fetch(FetchMode.JOIN)
    private Company company;

    @OneToMany(mappedBy = "purchase_buyer", fetch = FetchType.LAZY)
    private List<PurchaseBuyerItem> purchaseBuyerItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDetaill() {
        return detail;
    }

    public void setDetaill(String detaill) {
        this.detail = detaill;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<PurchaseBuyerItem> getPurchaseBuyerItems() {
        return purchaseBuyerItems;
    }

    public void setPurchaseBuyerItems(List<PurchaseBuyerItem> purchaseBuyerItems) {
        this.purchaseBuyerItems = purchaseBuyerItems;
    }

}
