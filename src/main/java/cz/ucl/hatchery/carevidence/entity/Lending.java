package cz.ucl.hatchery.carevidence.entity;

import cz.ucl.hatchery.carevidence.entity.client.Client;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Class representing Lending entity
 */
@Entity
public class Lending {

    @Id
    @SequenceGenerator(name = "LENDING_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LENDING_ID_GENERATOR")
    private Long id;

    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "car_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @Column(name = "lattitude")
    private Float latitude;

    private Float longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
