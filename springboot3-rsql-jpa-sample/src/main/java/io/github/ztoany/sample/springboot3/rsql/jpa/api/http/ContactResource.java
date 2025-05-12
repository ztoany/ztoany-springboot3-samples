package io.github.ztoany.sample.springboot3.rsql.jpa.api.http;


import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactResource {
    private final ContactService contactService;
    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ContactDto create(@RequestBody ContactBaseDto dto) {
        return contactService.create(dto);
    }

    @GetMapping("/{id}")
    public ContactDto getById(@PathVariable("id") String id) {
        return contactService.getById(id);
    }

    @GetMapping
    public List<ContactDto> list(String filter, String sort) {
        return contactService.list(filter, sort);
    }
}
