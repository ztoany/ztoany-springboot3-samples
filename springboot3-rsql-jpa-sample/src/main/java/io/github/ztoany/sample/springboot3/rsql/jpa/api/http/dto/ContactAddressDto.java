package io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto;

import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactAddressEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

@Data
public class ContactAddressDto {
    private String id;

    private String country;

    private String province;

    private String city;

    private String street;

    public void init() {
        this.id = null;

        if(!StringUtils.hasText(this.country)) {
            this.country = "";
        }

        if(!StringUtils.hasText(this.province)) {
            this.province = "";
        }

        if(!StringUtils.hasText(this.city)) {
            this.city = "";
        }

        if(!StringUtils.hasText(this.street)) {
            this.street = "";
        }
    }

    public static ContactAddressDto of(ContactAddressEntity entity) {
        if (entity == null) {
            return null;
        }

        ContactAddressDto dto = new ContactAddressDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
