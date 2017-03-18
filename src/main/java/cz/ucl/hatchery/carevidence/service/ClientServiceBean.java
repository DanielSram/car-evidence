package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.dao.ClientDAO;
import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.entity.client.ClientFactory;
import cz.ucl.hatchery.carevidence.model.ClientDTO;
import cz.ucl.hatchery.carevidence.model.ClientNewForm;
import cz.ucl.hatchery.carevidence.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceBean implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public void createClient(ClientNewForm clientForm) {
        Client client = ClientFactory.getInstance(clientForm);
        clientDAO.save(client);
    }

    public List<ClientDTO> getAll() {
        return DTOConverter.convertClient(clientDAO.findAll());
    }

    public ClientDTO findById(Long id) {
        return DTOConverter.convert(clientDAO.findById(id));
    }

    public Client getEntity(Long id) {
        return clientDAO.findById(id);
    }
}
