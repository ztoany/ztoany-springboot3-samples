package io.github.ztoany.sample.springboot3.ztoanystarter.service;

import io.github.ztoany.infra.springboot.exception.BusinessException;
import io.github.ztoany.sample.springboot3.ztoanystarter.api.http.CustomerRequest;
import io.github.ztoany.sample.springboot3.ztoanystarter.dao.CustomerJpaRepository;
import io.github.ztoany.sample.springboot3.ztoanystarter.domain.model.Customer;
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
        return customerJpaRepository.findById(id).orElseThrow(() -> entityNotFoundException(id));
    }

    @Override
    @Transactional
    public Customer createCustomer(CustomerRequest request) {
        return customerJpaRepository.save(Customer.of(request));
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long id, CustomerRequest request) {
        var customer = customerJpaRepository.findById(id).orElseThrow(() -> entityNotFoundException(id));
        customer.setName(request.getName());
        return customer;
    }

    private BusinessException entityNotFoundException(Long id) {
        return new BusinessException("E10000001", String.format("Customer %d not found", id));
    }
}
