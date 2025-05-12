package io.github.ztoany.sample.springboot3.rsql.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RsqlJpaApp {
    public static void main(String[] args) {
        SpringApplication.run(RsqlJpaApp.class, args);
    }
}
