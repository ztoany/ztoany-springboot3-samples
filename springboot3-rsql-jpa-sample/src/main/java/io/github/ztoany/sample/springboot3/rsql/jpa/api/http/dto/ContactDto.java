package io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto;

import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.time.Instant;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactDto extends ContactBaseDto {
    private String id;
    private Instant createdAt;

    public static ContactDto from(ContactEntity entity) {
        if (entity == null) {
            return null;
        }

        ContactDto dto = new ContactDto();
        BeanUtils.copyProperties(entity, dto);
        var addresses = entity.getContactAddresses();
        if (addresses != null) {
            dto.setContactAddresses(addresses.stream().map(ContactAddressDto::of).toList());
        } else {
            dto.setContactAddresses(new ArrayList<>());
        }

        return dto;
    }
}
