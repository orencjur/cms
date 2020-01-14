package cms.rest;

import cms.model.Regularuser;
import cms.model.Shipment;
import cms.model.Systemmanager;
import cms.model.Vehicle;
import cms.service.ShipmentService;
import cms.service.SystemmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/manager")
public class ManagerController {
    private final SystemmanagerService service;


    @Autowired
    public ManagerController (SystemmanagerService service) {
        this.service = service;

    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Systemmanager find(@PathVariable String id) {
        return service.find(id);
    }



    @PutMapping(value = "/managers/shipments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean processShipment(@RequestBody Shipment shipment, Vehicle v){
        return service.processShipment(shipment.getId(),v.getLicenseplate());
    }


    @DeleteMapping(value = "/managers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUser(@RequestBody Regularuser u){
        return service.deleteUser(u.getUsername());
    }

    @PutMapping(value = "/managers/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean createUser(@RequestBody Regularuser u) {
        return service.createUser(u.getUsername(),u.getPassword(),u.getFullname(),u.getLicensenumber());
    }



}