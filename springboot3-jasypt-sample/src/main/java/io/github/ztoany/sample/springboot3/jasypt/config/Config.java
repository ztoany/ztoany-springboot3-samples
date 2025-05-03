package io.github.ztoany.sample.springboot3.jasypt.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final DataSourceProperties dataSourceProperties;
    public Config(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @PostConstruct
    public void init() {
        System.out.println(dataSourceProperties.getPassword());
    }
}
