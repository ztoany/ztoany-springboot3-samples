package io.github.ztoany.sample.springboot3.rsql.jpa.service;

import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto create(ContactBaseDto dto);
    ContactDto getById(String id);
    List<ContactDto> list(String filter, String sort);
}
