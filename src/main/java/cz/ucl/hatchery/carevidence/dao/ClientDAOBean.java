package cz.ucl.hatchery.carevidence.dao;

import cz.ucl.hatchery.carevidence.entity.client.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOBean extends GenericHibernateDAO<Client, Long> implements ClientDAO {


}
