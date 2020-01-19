package cms.dao;

import org.springframework.stereotype.Repository;
import cms.model.Vehicle;
import cms.model.Regularuser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Repository
public class VehicleDao extends baseDao<Vehicle>{

    @PersistenceContext
    private EntityManager em;

    public VehicleDao() {
        super(Vehicle.class);
    }

    public void createVehicle(String licensePlate) throws Exception{
            Vehicle v = new Vehicle();
            v.setAvailability(true);
            v.setLicenseplate(licensePlate);
            em.persist(v);
    }

    public Vehicle find(String licensePlate){
        Objects.requireNonNull(licensePlate);
        return em.find(Vehicle.class, licensePlate);
    }

    public void assignVehicle(String licensePlate, String username){
        Regularuser user = em.find(Regularuser.class, username);
        user.setVehicleid(licensePlate);
        em.persist(user);
    }

    public void destroyVehicle(String licensePlate){
        Vehicle v = em.find(Vehicle.class, licensePlate);
        em.remove(v);
    }
}
