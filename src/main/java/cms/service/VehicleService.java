package cms.service;


import cms.dao.VehicleDao;
import cms.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleService {

    private final VehicleDao dao;

    @Autowired
    public VehicleService(VehicleDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void createVehicle (String licensePlate)throws Exception{
        dao.createVehicle(licensePlate);
    }

    @Transactional
    public Vehicle find(String licensePlate){
        return dao.find(licensePlate);
    }

    @Transactional
    public void assignVehicle(String licensePlate, String username){
        dao.assignVehicle(licensePlate,username);
    }
    @Transactional
    public void destroyVehicle(String licensePlate){
        dao.destroyVehicle(licensePlate);
    }

}
