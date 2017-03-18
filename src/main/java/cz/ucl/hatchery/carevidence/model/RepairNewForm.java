package cz.ucl.hatchery.carevidence.model;

import java.math.BigDecimal;

public class RepairNewForm {

    private Long car;

    private BigDecimal price;

    private String description;

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
