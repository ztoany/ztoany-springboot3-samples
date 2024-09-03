package io.github.ztoany.sample.springboot3.data.jpa.h2.api.http;

import jakarta.validation.constraints.NotBlank;

public class CustomerRequest {
    @NotBlank(message = "name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
