package io.github.ztoany.sample.springboot3.rsql.jpa.api.http;


import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.service.ContactService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

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
    public PagedModel<ContactDto> list(String filter, Pageable pageable) {
        return new PagedModel<>(contactService.list(filter, pageable));
    }
}
