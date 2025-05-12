package io.github.ztoany.sample.springboot3.rsql.jpa.api.http.dto;


import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.ContactPhoneNumber;
import io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity.Gender;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContactBaseDto {
    private String name;
    private List<String> formerNames;
    private Gender gender;
    private List<ContactPhoneNumber> contactPhoneNumbers;
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

        if(this.contactPhoneNumbers == null) {
            this.contactPhoneNumbers = new ArrayList<>();
        } else {
            this.contactPhoneNumbers.forEach(ContactPhoneNumber::init);
        }

        if(this.contactAddresses == null) {
            this.contactAddresses = new ArrayList<>();
        } else {
            this.contactAddresses.forEach(ContactAddressDto::init);
        }
    }

}
