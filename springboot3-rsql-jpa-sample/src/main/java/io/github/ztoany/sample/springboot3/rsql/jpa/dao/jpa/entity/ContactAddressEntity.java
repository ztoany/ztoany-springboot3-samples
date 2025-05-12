package io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "CONTACT_ADDRESS")
@Data
public class ContactAddressEntity {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;
}
