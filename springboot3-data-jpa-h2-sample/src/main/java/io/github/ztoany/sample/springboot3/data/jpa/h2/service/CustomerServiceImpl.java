package io.github.ztoany.sample.springboot3.data.jpa.h2.service;

import io.github.ztoany.sample.springboot3.data.jpa.h2.api.http.CustomerRequest;
import io.github.ztoany.sample.springboot3.data.jpa.h2.dao.CustomerJpaRepository;
import io.github.ztoany.sample.springboot3.data.jpa.h2.domain.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerServiceImpl(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    @Transactional
    public Customer findCustomerById(Long id) {
        return customerJpaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Customer createCustomer(CustomerRequest request) {
        return customerJpaRepository.save(Customer.of(request));
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long id, CustomerRequest request) {
        var customer = customerJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found"));
        customer.setName(request.getName());
        return customer;

    }
}
