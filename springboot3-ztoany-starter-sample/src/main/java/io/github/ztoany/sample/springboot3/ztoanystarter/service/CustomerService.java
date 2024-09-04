package io.github.ztoany.sample.springboot3.ztoanystarter.service;


import io.github.ztoany.sample.springboot3.ztoanystarter.api.http.CustomerRequest;
import io.github.ztoany.sample.springboot3.ztoanystarter.domain.model.Customer;

public interface CustomerService {
    Customer findCustomerById(Long id);
    Customer createCustomer(CustomerRequest request);
    Customer updateCustomer(Long id, CustomerRequest request);
}
