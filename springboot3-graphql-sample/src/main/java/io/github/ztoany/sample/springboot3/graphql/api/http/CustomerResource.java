package io.github.ztoany.sample.springboot3.graphql.api.http;

import io.github.ztoany.sample.springboot3.graphql.dao.jpa.entity.Customer;
import io.github.ztoany.sample.springboot3.graphql.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerResource {
    private final CustomerService customerService;
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") String id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}
