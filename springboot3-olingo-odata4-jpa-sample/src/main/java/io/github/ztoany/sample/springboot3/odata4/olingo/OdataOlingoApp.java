package io.github.ztoany.sample.springboot3.odata4.olingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OdataOlingoApp {
    public static void main(String[] args) {
        SpringApplication.run(OdataOlingoApp.class, args);
    }
}
