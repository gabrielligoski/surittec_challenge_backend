package com.surittec.surittec_challenge_backend.service.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.surittec.surittec_challenge_backend.model.enumeration.PhoneType;
import lombok.Data;

// Tried to use DTO, but it's broken somehow
@Data
public class PhoneDTO implements Serializable {

    private static final long serialVersionUID = -6539883214459824725L;
    private Long id;

    @NotNull
    private Long phone;

    @NotNull
    private PhoneType type;

    public PhoneDTO(Long phone, PhoneType type) {
        this.phone = phone;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
