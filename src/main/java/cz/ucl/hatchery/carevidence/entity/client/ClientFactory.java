package cz.ucl.hatchery.carevidence.entity.client;

import cz.ucl.hatchery.carevidence.model.ClientNewForm;
import cz.ucl.hatchery.carevidence.util.CoreDateUtil;

/**
 * Factory class for creating Client objects
 */
public class ClientFactory {

    /**
     * Takes ClientNewForm instance and returns Person or Company entity
     * @param clientForm
     * @return Person or Company entity
     */
    public static Client getInstance(ClientNewForm clientForm) {
        if (clientForm.getCRN() != null) {
            Company client = new Company();
            client.setCRN(clientForm.getCRN());
            client.setName(clientForm.getName());
            client.setEmail(clientForm.getEmail());
            client.setPhone(clientForm.getPhone());
            client.setAddress(clientForm.getAddress());
            client.setRegistrationDate(CoreDateUtil.getNow());
            return client;
        } else {
            Person client = new Person();
            client.setSurname(clientForm.getSurname());
            client.setName(clientForm.getName());
            client.setEmail(clientForm.getEmail());
            client.setPhone(clientForm.getPhone());
            client.setAddress(clientForm.getAddress());
            client.setRegistrationDate(CoreDateUtil.getNow());
            return client;
        }
    }

}
