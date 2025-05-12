package io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "CONTACT")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ContactEntity {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @Type(JsonType.class)
    @Column(nullable = false, columnDefinition = "jsonb")
    private List<String> formerNames;

    @Column(nullable = false)
    private Gender gender = Gender.NONE;

    @Type(JsonType.class)
    @Column(nullable = false, columnDefinition = "jsonb")
    private List<ContactPhoneNumber> contactPhoneNumbers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<ContactAddressEntity> contactAddresses;
}
