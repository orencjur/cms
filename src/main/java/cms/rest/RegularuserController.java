package cms.rest;

import cms.model.Regularuser;
import cms.model.Shipment;
import cms.service.RegularuserService;
import cms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/regularuser")
public class RegularuserController {

    private final RegularuserService service;


    @Autowired
    public RegularuserController(RegularuserService service) {
        this.service = service;

    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Regularuser getUser(@PathVariable String id) {
        return service.find(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Regularuser> findAll(){
        return service.findAll();
    }

    @PutMapping(value = "/finished", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setfinished(String description,@RequestBody Shipment shipment){
         service.setShipmentFinished(shipment.getId(),description);
    }



    @PutMapping(value = "/regularsers/failed", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setfailed(@RequestBody Shipment shipment) {
        service.setShipmentFailed(shipment.getId());
    }



}

