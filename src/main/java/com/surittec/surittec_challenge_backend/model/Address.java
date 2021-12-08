package com.surittec.surittec_challenge_backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "address")
public class Address {

    private static final long serialVersionUID = -6635468854462777693L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "address_id")
    private Person person;
    @Column(name = "zip")
    private String zip;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "complement")
    private String complement;

    public Address(String zip, String street, String district, String city, String state, String complement) {
        this.zip = zip;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    public Address(String zip, String street, String district, String city, String state) {
        this.zip = zip;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.complement = "";
    }

    public Address() {

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

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
