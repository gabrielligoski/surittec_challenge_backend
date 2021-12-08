package com.surittec.surittec_challenge_backend.model.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.surittec.surittec_challenge_backend.model.enumeration.PhoneType;
import lombok.Data;

@Data
public class PhoneDTO implements Serializable {

    private Long id;

    @NotNull
    private Long phone;

    @NotNull
    private PhoneType type;
}
