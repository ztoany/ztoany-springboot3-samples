package io.github.ztoany.sample.springboot3.querydsl.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaAuditing
@EnableSpringDataWebSupport
public class QueryDslJpaApp {
    public static void main(String[] args) {
        SpringApplication.run(QueryDslJpaApp.class, args);
    }
}
