package io.github.ztoany.sample.springboot3.data.jpa.h2.domain.model;

import io.github.ztoany.sample.springboot3.data.jpa.h2.api.http.CustomerRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Customer of(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        return customer;
    }
}
