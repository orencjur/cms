package cms.rest;

import cms.model.Regularuser;
import cms.model.Shipment;
import cms.model.Vehicle;
import cms.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/vehicle")
public class VehicleController {


        private final VehicleService vehicleService;


        @Autowired
        public VehicleController(VehicleService vehicleService) {
            this.vehicleService = vehicleService;

        }

        @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Vehicle getVehicle(@PathVariable String id) {
            return vehicleService.find(id);
        }


        @PutMapping(value = "/vehicles/assign", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void assign( @RequestBody Vehicle v, Regularuser u){
             vehicleService.assignVehicle(v.getLicenseplate(),u.getUsername());
        }



        @DeleteMapping(value = "/vehicles/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void deleteVehicle(@RequestBody Vehicle v){
            vehicleService.destroyVehicle(v.getLicenseplate());
        }

        @PutMapping(value = "/vehicles/shipment", consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void createShipment(@RequestBody Vehicle v) throws Exception{
            vehicleService.createVehicle(v.getLicenseplate());
        }



    }

