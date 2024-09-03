package io.github.ztoany.sample.springboot3.data.jpa.pg.service;


import io.github.ztoany.sample.springboot3.data.jpa.pg.api.http.CustomerRequest;
import io.github.ztoany.sample.springboot3.data.jpa.pg.domain.model.Customer;

public interface CustomerService {
    Customer findCustomerById(Long id);
    Customer createCustomer(CustomerRequest request);
    Customer updateCustomer(Long id, CustomerRequest request);
}
