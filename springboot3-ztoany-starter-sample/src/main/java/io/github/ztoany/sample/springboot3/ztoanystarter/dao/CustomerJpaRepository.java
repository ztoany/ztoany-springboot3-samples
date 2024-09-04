package io.github.ztoany.sample.springboot3.ztoanystarter.dao;

import io.github.ztoany.sample.springboot3.ztoanystarter.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
