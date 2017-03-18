package cz.ucl.hatchery.carevidence.util;

import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.Lending;
import cz.ucl.hatchery.carevidence.model.CarNeedingRevisionDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarNeedingRevisionDTOConverter {

    public static List<CarNeedingRevisionDTO> convert(final List<Object[]> queryResult) {
        List<CarNeedingRevisionDTO> dtos = new ArrayList<CarNeedingRevisionDTO>();

        for (final Object[] items : queryResult) {

            dtos.add(convert((Car) items[0], (Lending) items[1], items[2]));

        }

        return dtos;
    }

    private static CarNeedingRevisionDTO convert(final Car car, final Lending lending, Object date) {
        final CarNeedingRevisionDTO dto = new CarNeedingRevisionDTO();

        dto.setId(car.getId());
        dto.setType(car.getType().toString());
        dto.setNickname(car.getNickname());
        dto.setVin(car.getVin());
        dto.setId(car.getId());

        if (lending != null) {
            dto.setClientId(lending.getClient().getId());
            dto.setClientName(lending.getClient().getName());
            dto.setLendingId(lending.getId());
            dto.setReturnDate(lending.getDateTo());
        }

        if (date instanceof Date) {
            //dto.setExpirationDate(CoreDateUtil.alterDate((Date) date, 1, Calendar.YEAR));
            dto.setExpirationDate((Date) date);
        }

        return dto;
    }

}
