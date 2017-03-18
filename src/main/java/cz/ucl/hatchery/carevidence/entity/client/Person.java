package cz.ucl.hatchery.carevidence.entity.client;

import javax.persistence.Entity;

/**
 * Class representing Person entity
 */
@Entity
public class Person extends Client {

    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
