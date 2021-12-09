package com.surittec.surittec_challenge_backend.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

// Tried to use DTO, but it's broken somehow
@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1341807890585994760L;
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
    private String state;

    public AddressDTO(String zip, String street, String complement, String district, String city, String state) {
        this.zip = zip;
        this.street = street;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
