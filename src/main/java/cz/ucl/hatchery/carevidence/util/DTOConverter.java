/**
 *
 */
package cz.ucl.hatchery.carevidence.util;

import java.util.ArrayList;
import java.util.List;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.Lending;
import cz.ucl.hatchery.carevidence.entity.Repair;
import cz.ucl.hatchery.carevidence.entity.TechnicalRevision;
import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.entity.client.Company;
import cz.ucl.hatchery.carevidence.entity.client.Person;
import cz.ucl.hatchery.carevidence.model.*;

/**
 * @author User
 */
public class DTOConverter {

    public static CarDTO convert(final Car car) {
        final CarDTO dto = new CarDTO();

        dto.setId(car.getId());
        dto.setPrice(car.getPrice());
        dto.setVin(car.getVin());
        dto.setCarState(car.getCarState().name());
        dto.setType(car.getType().name());
        dto.setDateOfAcquisition(car.getDateOfAcquisition());
        dto.setDateOfLastTechnicalCheck(car.getDateOfLastTechnicalCheck());
        dto.setNickname(car.getNickname());

        return dto;
    }

    public static ClientDTO convert(final Client client) {
        final ClientDTO dto = new ClientDTO();

        if (client instanceof Company) {
            Company company = (Company) client;
            dto.setId(company.getId());
            dto.setCRN(company.getCRN());
            dto.setName(company.getName());
            dto.setEmail(company.getEmail());
            dto.setPhone(company.getPhone());
            dto.setRegistrationDate(company.getRegistrationDate());
            dto.setAddress(company.getAddress());
        } else {
            Person person = (Person) client;
            dto.setId(person.getId());
            dto.setSurname(person.getSurname());
            dto.setName(person.getName());
            dto.setEmail(person.getEmail());
            dto.setPhone(person.getPhone());
            dto.setRegistrationDate(person.getRegistrationDate());
            dto.setAddress(person.getAddress());
        }

        return dto;
    }

    public static List<CarDTO> convert(final List<Car> cars) {
        final List<CarDTO> dtos = new ArrayList<CarDTO>();

        for (final Car car : cars) {
            dtos.add(convert(car));
        }

        return dtos;
    }

    public static List<RepairDTO> convertRepair(final List<Repair> repairs) {
        final List<RepairDTO> dtos = new ArrayList<RepairDTO>();

        for (final Repair r : repairs) {
            dtos.add(convert(r));
        }
        return dtos;
    }

    public static List<TechnicalRevisionDTO> convertRevisions(final List<TechnicalRevision> revisions) {
        final List<TechnicalRevisionDTO> dtos = new ArrayList<TechnicalRevisionDTO>();

        for (final TechnicalRevision revision : revisions) {
            dtos.add(convert(revision));
        }

        return dtos;
    }

    public static TechnicalRevisionDTO convert(final TechnicalRevision revision) {
        final TechnicalRevisionDTO dto = new TechnicalRevisionDTO();

        dto.setId(revision.getId());
        dto.setCar(revision.getCar().getId());
        dto.setCheckDate(revision.getCheckDate());
        dto.setDescription(revision.getDescription());
        dto.setIsPass(revision.getIsPass());

        return dto;
    }

    public static RepairDTO convert(final Repair repair) {
        final RepairDTO dto = new RepairDTO();

        dto.setDescription(repair.getDescription());
        dto.setPrice(repair.getPrice());
        dto.setId(repair.getId());
        dto.setCar(repair.getCar().getId());

        return dto;
    }

    public static List<ClientDTO> convertClient(final List<Client> clients) {
        final List<ClientDTO> dtos = new ArrayList<ClientDTO>();

        for (final Client client : clients) {
            dtos.add(convert(client));
        }

        return dtos;
    }

    public static LendingDTO convert(final Lending lending) {
        final LendingDTO dto = new LendingDTO();

        dto.setId(lending.getId());
        dto.setCar(lending.getCar().getId());
        dto.setClient(lending.getClient().getId());
        dto.setDateFrom(lending.getDateFrom());
        dto.setDateTo(lending.getDateTo());
        dto.setLatitude(lending.getLatitude());
        dto.setLongitude(lending.getLongitude());
        dto.setPrice(lending.getPrice());

        return dto;
    }

}
