package io.github.ztoany.sample.springboot3.keycloak.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/app")
    public String app() {
        return "app";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/keycloak";
    }

}
