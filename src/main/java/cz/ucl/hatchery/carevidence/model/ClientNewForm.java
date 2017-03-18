package cz.ucl.hatchery.carevidence.model;

import java.util.Date;

/**
 * Class containing new client form data
 */
public class ClientNewForm {

    private String phone;
    private Date registrationDate;
    private String email;
    private String name;
    private String address;
    private Long CRN;
    private String surname;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCRN() {
        return CRN;
    }

    public void setCRN(Long CRN) {
        this.CRN = CRN;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
