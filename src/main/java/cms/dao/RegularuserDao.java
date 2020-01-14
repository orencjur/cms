package cms.dao;

import org.springframework.stereotype.Repository;
import cms.model.Regularuser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import cms.model.Shipment;

@Repository
public class RegularuserDao extends baseDao<Regularuser>{

    @PersistenceContext
    private EntityManager em;

    public RegularuserDao() {
        super(Regularuser.class);
    }

    public Regularuser find(String username){
        Objects.requireNonNull(username);
        return em.find(Regularuser.class, username);
    }

    public List<Regularuser> findAll(){
        return em.createQuery("SELECT u FROM Regularuser u WHERE u.username IS NOT NULL", Regularuser.class).getResultList();
    }

    public void setShipmentFinished(Integer id){
        Objects.requireNonNull(id);
        Shipment s = em.find(Shipment.class, id);
        s.setStatus("Finished");
        em.getTransaction();
        em.persist(s);
        em.getTransaction().commit();
    }

    public void setShipmentFailed(Integer id){
        Objects.requireNonNull(id);
        Shipment s = em.find(Shipment.class, id);
        s.setStatus("failed");
        em.getTransaction();
        em.persist(s);
        em.getTransaction().commit();
    }
}
