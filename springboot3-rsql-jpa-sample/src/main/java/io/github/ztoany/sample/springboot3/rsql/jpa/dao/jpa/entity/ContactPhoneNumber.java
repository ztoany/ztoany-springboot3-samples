package io.github.ztoany.sample.springboot3.rsql.jpa.dao.jpa.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class ContactPhoneNumber {
    private String phoneNumber;
    private String phoneNumberLabel;

    public void init() {
        if(!StringUtils.hasText(phoneNumber)) {
            phoneNumber = "";
        }

        if(!StringUtils.hasText(phoneNumberLabel)) {
            this.phoneNumberLabel = "";
        }
    }
}
