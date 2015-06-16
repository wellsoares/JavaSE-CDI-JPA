/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casa.ferias.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author well
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(nullable = false)
    @SequenceGenerator(sequenceName = "seq_product", allocationSize = 20, name = "id")
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
    @Column(name= "category", length=20)
    private String category;
    @Column(name="name", length=30)
    private String name;
    @Column(name="manufactory", length=15)
    private String manufactory;
    @Column(name="bulk", length=10)
    private String bulk;
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }
}