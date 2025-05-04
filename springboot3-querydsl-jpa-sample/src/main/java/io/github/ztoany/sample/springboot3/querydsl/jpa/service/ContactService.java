package io.github.ztoany.sample.springboot3.querydsl.jpa.service;

import com.querydsl.core.types.Predicate;
import io.github.ztoany.sample.springboot3.querydsl.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.querydsl.jpa.api.http.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    ContactDto create(ContactBaseDto dto);
    ContactDto getById(String id);
    Page<ContactDto> list(Predicate predicate, Pageable pageable);
}
