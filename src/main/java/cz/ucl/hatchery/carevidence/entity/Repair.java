package cz.ucl.hatchery.carevidence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Class representing Repair entity
 */
@Entity
@Table(name = "car_repair")
@NamedQueries({
        @NamedQuery(name = Repair.REPAIRS_FOR_CAR_QUERY_NAME,
                query = "SELECT repair FROM Repair repair WHERE repair.car.id = :carId")
})
public class Repair {

    public static final String REPAIRS_FOR_CAR_QUERY_NAME = "Repair.forCar";

    @Id
    @SequenceGenerator(name = "REPAIR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPAIR_ID_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    private BigDecimal price;

    @Column(name = "repair_resolution")
    private String description;

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
