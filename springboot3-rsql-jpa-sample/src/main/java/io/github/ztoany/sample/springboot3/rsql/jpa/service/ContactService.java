package io.github.ztoany.sample.springboot3.rsql.jpa.service;

import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    ContactDto create(ContactBaseDto dto);
    ContactDto getById(String id);
    Page<ContactDto> list(String filter, Pageable pageable);
}
