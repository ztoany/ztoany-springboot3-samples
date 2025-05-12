package io.github.ztoany.sample.springboot3.rsql.jpa.service;

import io.github.perplexhub.rsql.RSQLJPASupport;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactBaseDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto.ContactDto;
import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactAddressEntity;
import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactEntity;
import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.repository.ContactEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactEntityRepository contactEntityRepository;

    public ContactServiceImpl(ContactEntityRepository contactEntityRepository) {
        this.contactEntityRepository = contactEntityRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ContactDto create(ContactBaseDto dto) {
        if(dto == null) {
            return null;
        }

        dto.init();
        ContactEntity contactEntity = new ContactEntity();
        BeanUtils.copyProperties(dto, contactEntity);

        var addresses = dto.getContactAddresses();
        var addressEntities = addresses.stream().map(e -> {
            ContactAddressEntity addressEntity = new ContactAddressEntity();
            BeanUtils.copyProperties(e, addressEntity);
            return addressEntity;
        }).toList();

        contactEntity.setContactAddresses(addressEntities);

        var entity = contactEntityRepository.saveAndFlush(contactEntity);
        return ContactDto.from(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ContactDto getById(String id) {
        var entity = contactEntityRepository.findById(id).orElse(null);
        return ContactDto.from(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<ContactDto> list(String filter, Pageable pageable) {
        var spec = RSQLJPASupport.<ContactEntity>toSpecification(filter);
        var page = contactEntityRepository.findAll(spec, pageable);
        return page.map(ContactDto::from);
    }
}
