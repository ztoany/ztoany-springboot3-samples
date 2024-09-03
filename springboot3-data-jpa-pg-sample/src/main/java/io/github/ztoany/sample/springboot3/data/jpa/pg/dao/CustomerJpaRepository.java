package io.github.ztoany.sample.springboot3.data.jpa.pg.dao;


import io.github.ztoany.sample.springboot3.data.jpa.pg.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
