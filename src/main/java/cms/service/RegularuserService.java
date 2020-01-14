package cms.service;

import cms.dao.ArchiveDao;
import cms.dao.RegularuserDao;
import cms.dao.ShipmentDao;
import cms.model.Regularuser;
import cms.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegularuserService {

    private final RegularuserDao dao;
    private final ArchiveDao archivedao;
    private final ShipmentDao shipmentdao;

    @Autowired
    public RegularuserService(RegularuserDao dao,ArchiveDao archivedao,ShipmentDao shipmentdao) {
        this.archivedao=archivedao;
        this.shipmentdao=shipmentdao;
        this.dao = dao;
    }

    @Transactional
    public Regularuser find(String username){
        return dao.find(username);
    }

    @Transactional
    public List<Regularuser> findAll(){
        return dao.findAll();
    }
    @Transactional
    public void setShipmentFinished(Integer id, String description){
        dao.setShipmentFinished(id);
        Shipment shipment = shipmentdao.find(id);
        archivedao.archiveShipment(id,description,shipment.getStatus());
        shipmentdao.deleteShipment(id);
    }
    @Transactional
    public void setShipmentFailed(Integer id){
        dao.setShipmentFailed(id);
    }
}
