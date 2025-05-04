package io.github.ztoany.sample.springboot3.querydsl.jpa.dao.jpa.entity;

import com.querydsl.core.annotations.QueryExclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@QueryExclude
public class ExcludeEntity {
    @Id
    @UuidGenerator
    private String id;
}
