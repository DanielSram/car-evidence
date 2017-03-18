package cz.ucl.hatchery.carevidence.model;

import java.util.Date;

/**
 * Class containing new Technical Revision form data
 */
public class NewTechnicalRevisionForm {

    private Long id;
    private Long car;
    private Date checkDate;
    private Character isPass;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Character getIsPass() {
        return isPass;
    }

    public void setIsPass(Character isPass) {
        this.isPass = isPass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
