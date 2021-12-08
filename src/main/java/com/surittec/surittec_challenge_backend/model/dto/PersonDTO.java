package com.surittec.surittec_challenge_backend.model.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.surittec.surittec_challenge_backend.model.Phone;
import lombok.Data;

@Data
public class PersonDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private Long cpf;

    @Size(min = 1)
    private List<Phone> phone;

    @Size(min = 1)
    private List<String> email;
}
