package cz.ucl.hatchery.carevidence.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import cz.ucl.hatchery.carevidence.model.enumeration.CarState;
import cz.ucl.hatchery.carevidence.model.enumeration.CarsType;

/**
 * @author DZCJS9F
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Car.AVAILABLE_CARS_QUERY_NAME,
                query = "SELECT car FROM Car car WHERE NOT EXISTS ( " +
                        "SELECT 1 FROM Lending lending WHERE ( " +
                        "(car.id = lending.car.id) AND " +
                        "(:newLendingDateFrom BETWEEN lending.dateFrom AND lending.dateTo) OR " +
                        "(:newLendingDateTo BETWEEN lending.dateFrom AND lending.dateTo) OR " +
                        "(:newLendingDateFrom < lending.dateFrom AND :newLendingDateTo > lending.dateTo)" +
                        ")" +
                        ") AND car.type = :carType " +
                        " AND car.carState = :carState"),
        @NamedQuery(name = Car.CARS_WITH_FORTHCOMING_REVISION_QUERY_NAME,
                query = "SELECT car, " +
                        "(SELECT len FROM car.lendings len WHERE trunc(systimestamp) BETWEEN len.dateFrom AND len.dateTo ) AS currentLending, " +
                        "(SELECT max(tr.checkDate) FROM car.revisions tr) AS lastCheckDate " +
                        "FROM Car car LEFT JOIN car.lendings lend " +
                        "WHERE NOT EXISTS " +
                        "   (SELECT 1 FROM car.revisions revision WHERE " +
                        "   (revision.isPass = 'Y' AND revision.checkDate >= :dayBeforeTenMonths)) " +
                        "AND (car.carState NOT LIKE :newCarState) AND (car.carState NOT LIKE :disabledCarState) ")
})
public class Car {

    public static final String AVAILABLE_CARS_QUERY_NAME = "Car.findAvailable";

    public static final String CARS_WITH_FORTHCOMING_REVISION_QUERY_NAME = "Car.withForthcomingRevision";

    @Id
    @SequenceGenerator(name = "CAR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_ID_GENERATOR")
    private Long id;

    @Column(name = "cars_type")
    @Enumerated(EnumType.STRING)
    private CarsType type;

    private String vin;

    @Column(name = "state_type")
    @Enumerated(EnumType.STRING)
    private CarState carState;

    @Column(name = "date_of_acquisition")
    @Temporal(TemporalType.DATE)
    private Date dateOfAcquisition;

    @Column(name = "last_control")
    @Temporal(TemporalType.DATE)
    private Date dateOfLastTechnicalCheck;

    private BigDecimal price;

    @OneToMany(mappedBy = "car")
    private Set<TechnicalRevision> revisions;

    @OneToMany(mappedBy = "car")
    private Set<Lending> lendings;

    @OneToMany(mappedBy = "car")
    private Set<Repair> repairs;

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public Set<TechnicalRevision> getRevisions() {
        return revisions;
    }

    public void setRevisions(Set<TechnicalRevision> revisions) {
        this.revisions = revisions;
    }

    public Set<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(Set<Lending> lendings) {
        this.lendings = lendings;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public CarsType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final CarsType type) {
        this.type = type;
    }

    /**
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(final String vin) {
        this.vin = vin;
    }

    /**
     * @return the carState
     */
    public CarState getCarState() {
        return carState;
    }

    /**
     * @param carState the carState to set
     */
    public void setCarState(final CarState carState) {
        this.carState = carState;
    }

    /**
     * @return the dateOfAcquisition
     */
    public Date getDateOfAcquisition() {
        return dateOfAcquisition;
    }

    /**
     * @param dateOfAcquisition the dateOfAcquisition to set
     */
    public void setDateOfAcquisition(final Date dateOfAcquisition) {
        this.dateOfAcquisition = dateOfAcquisition;
    }

    /**
     * @return the dateOfLastTechnicalCheck
     */
    public Date getDateOfLastTechnicalCheck() {
        return dateOfLastTechnicalCheck;
    }

    /**
     * @param dateOfLastTechnicalCheck the dateOfLastTechnicalCheck to set
     */
    public void setDateOfLastTechnicalCheck(final Date dateOfLastTechnicalCheck) {
        this.dateOfLastTechnicalCheck = dateOfLastTechnicalCheck;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

}
