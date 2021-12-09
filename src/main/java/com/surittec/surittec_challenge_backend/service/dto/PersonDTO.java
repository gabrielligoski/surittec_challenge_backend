package com.surittec.surittec_challenge_backend.service.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.surittec.surittec_challenge_backend.model.Address;
import com.surittec.surittec_challenge_backend.model.Phone;
import lombok.Data;

// Tried to use DTO, but it's broken somehow
@Data
public class PersonDTO implements Serializable {

    private Long id;

    private static final long serialVersionUID = -2295146003820910944L;
    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private Long cpf;

    @NotNull
    private List<Phone> phone;

    @NotNull
    private List<String> email;

    @NotNull
    private Address address;

    public PersonDTO(String name, Long cpf, List<Phone> phone, List<String> email, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
