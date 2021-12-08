package com.surittec.surittec_challenge_backend.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AddressDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 5, max = 9)
    private String zip;

    @NotNull
    @Size(min = 3, max = 255)
    private String street;

    @Size(max = 255)
    private String complement;

    @NotNull
    @Size(min = 3, max = 255)
    private String district;

    @NotNull
    @Size(min = 3, max = 255)
    private String city;

    @NotNull
    @Size(min = 3, max = 255)
    private String state;

}
