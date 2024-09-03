package io.github.ztoany.sample.springboot3.ztoanystarter.api.http;

import io.github.ztoany.infra.springboot.exception.ExceptionBuilder;
import io.github.ztoany.infra.springboot.exception.PredefinedErrorCodes;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exceptions")
public class ExceptionTestController {
    @GetMapping("/business-exceptions")
    public String businessException() {
        throw ExceptionBuilder.businessException(PredefinedErrorCodes.SYSTEM_INTERNAL_ERROR);
    }

    @GetMapping("/unhandled-exceptions")
    public String unhandledException() {
        throw new RuntimeException("unhandled exception");
    }

    @PostMapping("/violation-exceptions")
    public CustomerRequest violation(@Valid @RequestBody CustomerRequest request) {
        return request;
    }
}
