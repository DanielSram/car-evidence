package cz.ucl.hatchery.carevidence.model;

import cz.ucl.hatchery.carevidence.model.enumeration.CarsType;

import java.util.Date;

/**
 * Filter used for finding available cars for lending
 */
public class AvailableCarFilter {

    private CarsType type;
    private Date availableFrom;
    private Date availableTo;

    public CarsType getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = CarsType.valueOf(type);
    }

    public void setType(CarsType type) {
        this.type = type;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(Date availableTo) {
        this.availableTo = availableTo;
    }

}
