package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.dao.TechnicalRevisionDAO;
import cz.ucl.hatchery.carevidence.entity.Car;
import cz.ucl.hatchery.carevidence.entity.TechnicalRevision;
import cz.ucl.hatchery.carevidence.model.NewTechnicalRevisionForm;
import cz.ucl.hatchery.carevidence.model.TechnicalRevisionDTO;
import cz.ucl.hatchery.carevidence.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service interface for Technical Revision entities
 */
@Service
@Transactional
public class TechnicalRevisionServiceBean implements TechnicalRevisionService {

    @Autowired
    private TechnicalRevisionDAO technicalRevisionDAO;

    /**
     * Creates new Technical Revision
     * @param form
     *          containing data of new revision
     * @param car
     *          that was revised
     */
    public void createTechnicalRevision(NewTechnicalRevisionForm form, Car car) {
        TechnicalRevision tr = new TechnicalRevision();
        tr.setCar(car);
        setFieldsFromDTO(form, tr);
        technicalRevisionDAO.save(tr);
    }

    /**
     * Fetches all Technical Revisions for given car ID.
     * @param carId
     *          id of car to list revisions for
     * @return List of TechnicalRevisionDTO
     */
    public List<TechnicalRevisionDTO> getRevisionsForCar(Long carId) {
        return DTOConverter.convertRevisions(technicalRevisionDAO.getRevisionsForCar(carId));
    }

    private void setFieldsFromDTO(NewTechnicalRevisionForm form, TechnicalRevision tr) {
        tr.setCheckDate(form.getCheckDate());
        tr.setDescription(form.getDescription());
        tr.setIsPass(form.getIsPass());
    }
}
