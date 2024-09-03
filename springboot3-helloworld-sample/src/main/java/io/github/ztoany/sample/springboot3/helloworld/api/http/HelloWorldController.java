package io.github.ztoany.sample.springboot3.helloworld.api.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloWorldController {
    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }
}
