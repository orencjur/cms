package cms.service;

import cms.dao.ArchiveDao;
import cms.model.Archive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArchiveService {

    private final ArchiveDao dao;


    @Autowired
    public ArchiveService(ArchiveDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public List<Archive> findAll() {
        return dao.getAll();
    }

    @Transactional
    public Archive findArchivedShipment(Integer id){
        return dao.findArchivedShipment(id);
    }
    @Transactional
    public boolean archiveShipment(Integer id, String description, String status){
        return dao.archiveShipment(id,description,status);

    }
}
