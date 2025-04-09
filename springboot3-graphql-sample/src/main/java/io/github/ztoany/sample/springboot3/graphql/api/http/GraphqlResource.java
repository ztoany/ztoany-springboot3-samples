package io.github.ztoany.sample.springboot3.graphql.api.http;

import io.github.ztoany.sample.springboot3.graphql.dao.jpa.entity.Customer;
import io.github.ztoany.sample.springboot3.graphql.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphqlResource {
    private final CustomerService customerService;
    public GraphqlResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public Customer getCustomerById(@Argument String id) {
        return customerService.getCustomer(id);
    }

    @QueryMapping
    public List<Customer> listAllCustomers() {
        return customerService.listAllCustomers();
    }
}
