package io.github.ztoany.sample.springboot3.ztoanystarter.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.github.ztoany.infra.springboot.hibernate.id.snowflake.SnowflakeId;
import io.github.ztoany.sample.springboot3.ztoanystarter.api.http.CustomerRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @SnowflakeId
    @JsonSerialize(using = ToStringSerializer.class)
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
