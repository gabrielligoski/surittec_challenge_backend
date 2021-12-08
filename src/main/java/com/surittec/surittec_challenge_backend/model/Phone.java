package com.surittec.surittec_challenge_backend.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.surittec.surittec_challenge_backend.model.enumeration.PhoneType;
import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone")
    private Long phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PhoneType type;

    public Phone(Long phone, PhoneType type) {
        this.phone = phone;
        this.type = type;
    }

    public Phone() {

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
