package io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.repository;

import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContactEntityRepository extends JpaRepository<ContactEntity, String>, JpaSpecificationExecutor<ContactEntity> {

}
