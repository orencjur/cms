package cms.dao;

import org.springframework.stereotype.Repository;
import cms.model.Archive;
import cms.model.Shipment;
import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class ArchiveDao extends baseDao<Archive>{


    @PersistenceContext
    private EntityManager em;

    protected ArchiveDao() {
        super(Archive.class);
    }

    @OrderBy("Archive.id ASC")
    public List<Archive> getAll(){
        return em.createNamedQuery("Archive.findAllRecords", Archive.class)
                .getResultList();

    }

    public Archive findArchivedShipment(Integer id){
        Objects.requireNonNull(id);
        return em.find(Archive.class, id);
    }

    public Shipment findShipment(Integer id){
        Objects.requireNonNull(id);
        return em.find(Shipment.class, id);
    }
    public boolean archiveShipment(Integer id, String description, String status){
        Shipment s = findShipment(id);
        Archive a = new Archive();
        a.setAssignedvehicle(s.getAssignedvehicle());
        a.setCargo(s.getCargo());
        a.setDescription(description);
        a.setStatus(status);
        a.setId(s.getId());
        a.setDestination(s.getDestination());
        try {
            em.persist(a);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
