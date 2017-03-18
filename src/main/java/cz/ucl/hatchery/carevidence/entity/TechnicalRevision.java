package cz.ucl.hatchery.carevidence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Class representing Technical revision entity
 */
@Entity
@Table(name = "car_stk")
@NamedQueries({
        @NamedQuery(name = TechnicalRevision.REVISIONS_FOR_CAR_QUERY_NAME,
                query = "SELECT tr FROM TechnicalRevision tr WHERE tr.car.id = :carId")
})
public class TechnicalRevision {

    public static final String REVISIONS_FOR_CAR_QUERY_NAME = "TechnicalRevision.forCar";

    @Id
    @SequenceGenerator(name = "STK_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STK_ID_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @Column(name = "check_date")
    @Temporal(TemporalType.DATE)
    private Date checkDate;

    @Column(name = "is_pass")
    private Character isPass;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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
}
