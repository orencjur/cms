package cms.rest;

import cms.model.Archive;
import cms.model.Shipment;
import cms.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/archive")
public class ArchiveController  {

    private final ArchiveService archiveService;


        @Autowired
        public ArchiveController(ArchiveService archiveService) {
            this.archiveService = archiveService;

        }

        @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Archive getArchiveShipment(@PathVariable int id) {
            return archiveService.findArchivedShipment(id);
        }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Archive> findAll(){
            return archiveService.findAll();
        }

        @PutMapping(value = "/archives", consumes = MediaType.APPLICATION_JSON_VALUE)
        public boolean archiveShipment(String description,@RequestBody Shipment shipment){
            return archiveService.archiveShipment(shipment.getId(),description,shipment.getStatus());
        }




}
