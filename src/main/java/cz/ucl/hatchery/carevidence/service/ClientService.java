package cz.ucl.hatchery.carevidence.service;

import cz.ucl.hatchery.carevidence.entity.client.Client;
import cz.ucl.hatchery.carevidence.model.ClientDTO;
import cz.ucl.hatchery.carevidence.model.ClientNewForm;

import java.util.List;

/**
 * Interface for managing Client entities
 */
public interface ClientService {

    /**
     * Creates new Client
     * @param clientForm
     */
    public void createClient(ClientNewForm clientForm);

    /**
     * Fetches all Clients
     * @return List of Client data transfer objects
     */
    List<ClientDTO> getAll();

    /**
     * Find Client by given id
     * @param id of client
     * @return Client data transfer objects
     */
    public ClientDTO findById(Long id);

    /**
     * Find Client by given id
     * @param id of client
     * @return Client entity
     */
    public Client getEntity(Long id);

}
