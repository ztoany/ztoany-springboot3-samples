package io.github.ztoany.sample.springboot3.data.jpa.h2.service;

import io.github.ztoany.sample.springboot3.data.jpa.h2.api.http.CustomerRequest;
import io.github.ztoany.sample.springboot3.data.jpa.h2.domain.model.Customer;

public interface CustomerService {
    Customer findCustomerById(Long id);
    Customer createCustomer(CustomerRequest request);
    Customer updateCustomer(Long id, CustomerRequest request);
}
