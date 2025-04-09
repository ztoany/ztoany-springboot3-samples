package io.github.ztoany.sample.springboot3.graphql.service;

import io.github.ztoany.sample.springboot3.graphql.dao.jpa.entity.Customer;
import io.github.ztoany.sample.springboot3.graphql.dao.jpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer getCustomer(String id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    @Transactional
    public List<Customer> listAllCustomers() {
        return this.customerRepository.findAll();
    }
}
