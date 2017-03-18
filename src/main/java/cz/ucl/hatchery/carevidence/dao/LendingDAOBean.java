package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.Lending;
import org.springframework.stereotype.Repository;

@Repository
public class LendingDAOBean extends GenericHibernateDAO<Lending, Long> implements LendingDAO {

}
