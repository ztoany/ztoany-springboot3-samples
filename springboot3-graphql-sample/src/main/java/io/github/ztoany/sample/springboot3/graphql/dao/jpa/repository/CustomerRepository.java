package io.github.ztoany.sample.springboot3.graphql.dao.jpa.repository;

import io.github.ztoany.sample.springboot3.graphql.dao.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface CustomerRepository extends JpaRepository<Customer, String>, QueryByExampleExecutor<Customer> {
}
