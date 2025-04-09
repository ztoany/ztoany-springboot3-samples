package io.github.ztoany.sample.springboot3.graphql.service;

import io.github.ztoany.sample.springboot3.graphql.dao.jpa.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String id);
    Customer createCustomer(Customer customer);
    List<Customer> listAllCustomers();
}
