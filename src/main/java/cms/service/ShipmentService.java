package cms.service;

import cms.dao.ShipmentDao;
import cms.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentDao dao;

    @Autowired
    public ShipmentService(ShipmentDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public Shipment find(Integer id){
        return dao.find(id);
    }
    @Transactional
    public List<Shipment> findAll(){
       return dao.findAll();
    }

    @Transactional
    public List<Shipment> findByStatus(String status){
        return dao.findByStatus(status);
    }
    @Transactional
    public boolean setStatus(String status, Integer id){
        return dao.setStatus(status,id);
    }
    @Transactional
    public boolean deleteShipment(Integer id){
        return dao.deleteShipment(id);
    }

    @Transactional
    public void createShipment(String cargo,  String destination){
        dao.createShipment(cargo,destination);
    }

}
