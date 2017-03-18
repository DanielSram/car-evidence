package cz.ucl.hatchery.carevidence.entity.client;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Class representing Company entity
 */
@Entity
public class Company extends Client {

    /**
     * IČO
     */
    @Column(name = "ICO")
    private Long CRN;

    public Long getCRN() {
        return CRN;
    }

    public void setCRN(Long CRN) {
        this.CRN = CRN;
    }

}
