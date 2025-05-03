package io.github.ztoany.sample.springboot3.jasypt.dao.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class Customer {
    @Id
    @UuidGenerator
    private String id;

    private String name;
}
