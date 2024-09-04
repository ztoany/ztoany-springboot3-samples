package io.github.ztoany.sample.springboot3.elide.domain.model;

import com.yahoo.elide.annotation.Include;
import jakarta.persistence.*;

@Include(rootLevel = false, name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String province = "";

    private String city = "";

    @ManyToOne
    private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
