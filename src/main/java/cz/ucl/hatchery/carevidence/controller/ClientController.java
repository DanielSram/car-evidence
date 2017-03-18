package cz.ucl.hatchery.carevidence.controller;

import cz.ucl.hatchery.carevidence.model.ClientDTO;
import cz.ucl.hatchery.carevidence.model.ClientNewForm;
import cz.ucl.hatchery.carevidence.service.ClientService;
import cz.ucl.hatchery.carevidence.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = ClientController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    public final static String BASE_URL = CommonConstants.SLASH + "clients";

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public void createClient(@RequestBody ClientNewForm clientForm) {
        clientService.createClient(clientForm);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ClientDTO[] getAll() {
        final List<ClientDTO> result = clientService.getAll();
        return result.toArray(new ClientDTO[result.size()]);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientDTO getCarById(@PathVariable Long id) {
        return id == null ? null : clientService.findById(id);
    }

}
