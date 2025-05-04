package io.github.ztoany.sample.springboot3.querydsl.jpa.dao.jpa.repository;

import io.github.ztoany.sample.springboot3.querydsl.jpa.dao.jpa.entity.ContactEntity;
import io.github.ztoany.sample.springboot3.querydsl.jpa.dao.jpa.entity.QContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface ContactEntityRepository extends JpaRepository<ContactEntity, String>,
        QuerydslPredicateExecutor<ContactEntity>, QuerydslBinderCustomizer<QContactEntity> {

    @Override
    default void customize(QuerydslBindings bindings, QContactEntity root) {

    }
}
