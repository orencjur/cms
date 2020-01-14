package cms.rest;

import cms.model.Archive;
import cms.model.Shipment;
import cms.service.ArchiveService;
import cms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentController {
    private final ShipmentService shipmentService;


    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;

    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Shipment getShipment(@PathVariable int id) {
        return shipmentService.find(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Shipment> findAll(){
        return shipmentService.findAll();
    }

    @PutMapping(value = "/shipments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean setStatus(String status,@RequestBody Shipment shipment){
        return shipmentService.setStatus(status,shipment.getId());
    }

    @GetMapping(value = "/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Shipment> findByStatus(@PathVariable String id){
        return shipmentService.findByStatus(id);
    }

    @DeleteMapping(value = "/shipments/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteShipment(@RequestBody Shipment shipment){
       return shipmentService.deleteShipment(shipment.getId());
    }

    @PutMapping(value = "/shipments/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createShipment(@RequestBody Shipment shipment) {
        shipmentService.createShipment(shipment.getCargo(),shipment.getDestination());
    }



}
