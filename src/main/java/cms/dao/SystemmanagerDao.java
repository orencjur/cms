package cms.dao;

import cms.model.Shipment;
import org.springframework.stereotype.Repository;
import cms.model.Systemmanager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import cms.model.Regularuser;

@Repository
public class SystemmanagerDao extends baseDao<Systemmanager>{

    @PersistenceContext
    private EntityManager em;


    protected SystemmanagerDao() {
        super(Systemmanager.class);
    }


    public Systemmanager find(String username){
        Objects.requireNonNull(username);
        return em.find(Systemmanager.class, username);
    }

    public boolean createUser(String username, String password, String fullName, String license){
        Regularuser user = new Regularuser();
        user.setFullname(fullName);
        user.setPassword(password);
        user.setUsername(username);
        user.setLicensenumber(license);
        try {
            em.persist(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteUser(String username){
        Objects.requireNonNull(username);
        Regularuser user = em.find(Regularuser.class, username);
        try {
            em.remove(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean processShipment(Integer id, String licensePlate){
        Objects.requireNonNull(id);
        Shipment s = em.find(Shipment.class, id);
        s.setAssignedvehicle(licensePlate);
        try{
            em.persist(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
