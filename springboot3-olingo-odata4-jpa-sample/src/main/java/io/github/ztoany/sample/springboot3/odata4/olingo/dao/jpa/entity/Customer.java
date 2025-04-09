package io.github.ztoany.sample.springboot3.odata4.olingo.dao.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    private String id;

    @Column(nullable = false, length = 128)
    private String name;

    @CreatedDate
    private Instant createdAt;
}
