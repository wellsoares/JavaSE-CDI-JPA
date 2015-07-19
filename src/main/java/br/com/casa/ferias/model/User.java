package br.com.casa.ferias.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author well
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    public User(Integer id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(sequenceName = "seq_users", allocationSize = 20, name = "id")
    @GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false, length = 40)
    private String name;
    @Column(name = "last_name", length = 40)
    private String lastName;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, length = 10)
    private String password;
    @Column(nullable = false, length = 40)
    private String email;
    @ManyToOne()
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "FK_COMPANY"))
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "User{" + "id= " + id + ", name= " + name + '}';
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
