package br.com.casa.ferias.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author well
 */
@Entity
@Table(name = "purchase_buyer_item")
public class PurchaseBuyerItem implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(sequenceName = "seq_purchase_buyer_item", allocationSize = 20, name = "id")
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @Fetch(FetchMode.JOIN)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_buyer_id")
    @Fetch(FetchMode.JOIN)
    private PurchaseBuyer purchase_buyer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseBuyer getPurchase_buyer() {
        return purchase_buyer;
    }

    public void setPurchase_buyer(PurchaseBuyer purchase_buyer) {
        this.purchase_buyer = purchase_buyer;
    }

}
