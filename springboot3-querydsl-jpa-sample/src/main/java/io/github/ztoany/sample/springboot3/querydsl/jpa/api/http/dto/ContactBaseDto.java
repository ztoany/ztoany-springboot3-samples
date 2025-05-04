package io.github.ztoany.sample.springboot3.querydsl.jpa.api.http.dto;

import io.github.ztoany.sample.springboot3.querydsl.jpa.dao.jpa.entity.Gender;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class ContactBaseDto {
    private String name;
    private List<String> formerNames;
    private Gender gender;
    private List<ContactAddressDto> contactAddresses;

    public void init() {
        if(!StringUtils.hasText(this.name)) {
            this.name = "";
        }

        if(this.formerNames == null) {
            this.formerNames = new ArrayList<>();
        }

        if(this.gender == null) {
            this.gender = Gender.NONE;
        }

        if(this.contactAddresses == null) {
            this.contactAddresses = new ArrayList<>();
        } else {
            this.contactAddresses.forEach(ContactAddressDto::init);
        }
    }

}
