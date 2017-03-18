package cz.ucl.hatchery.carevidence.entity.client;

import cz.ucl.hatchery.carevidence.entity.Lending;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Parent class for all client entities
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "car_client")
public abstract class Client {

    @Id
    @SequenceGenerator(name = "CLIENT_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_GENERATOR")
    private Long id;

    @Column(name = "ceil_phone")
    private String phone;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    private String email;

    private String name;

    @OneToMany(mappedBy = "client")
    private Set<Lending> lendings;

    private String address;

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(Set<Lending> lendings) {
        this.lendings = lendings;
    }

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

    public Long getId() {
        return id;
    }
}
