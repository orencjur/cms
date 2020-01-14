package cms.service;

import cms.dao.SystemmanagerDao;
import cms.model.Systemmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemmanagerService {

    private final SystemmanagerDao dao;

    @Autowired
    public SystemmanagerService(SystemmanagerDao dao) {
        this.dao = dao;
    }

    @Transactional
    public Systemmanager find(String username){
        return dao.find(username);
    }

    @Transactional
    public boolean createUser(String username, String password, String fullName, String license){
        return dao.createUser(username,password,fullName,license);

    }

    @Transactional
    public boolean deleteUser(String username){
        return dao.deleteUser(username);
    }

    @Transactional
    public boolean processShipment(Integer id, String licensePlate){
        return dao.processShipment(id,licensePlate);
    }

    @Transactional
    public boolean exists(String username){
        return dao.find(username) != null;
    }

    @Transactional
    public void persist(Systemmanager manager){
        dao.persist(manager);
    }

}
