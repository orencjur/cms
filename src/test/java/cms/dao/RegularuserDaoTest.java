package cms.dao;
import cms.Start;
import cms.model.Vehicle;
import cms.service.SystemInitializer;
import org.junit.Assert;
import org.junit.Test;
import cms.model.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// DataJpaTest does not load all the application beans, it starts only persistence-related stuff
@DataJpaTest
// Exclude SystemInitializer from the startup, we don't want the admin account here
@ComponentScan(basePackageClasses = Start.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SystemInitializer.class)})
public class RegularuserDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private RegularuserDao dao;

    @Autowired
    private SystemmanagerDao sm;


    @Test
    public  void CreateUserTest(){
        Regularuser r = new Regularuser();
        r.setFullname("Fetak Dusan");
        r.setLicensenumber("11111117");
        r.setPassword("pass");
        r.setUsername("dusko");
        sm.createUser("dusko", "pass", "Fetak Dusan", "11111117");
        Regularuser res = null;
        try {
            res = dao.find("dusko");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertSame(r.getPassword(), res.getPassword());
        Assert.assertSame(r.getUsername(), res.getUsername());
        Assert.assertSame(r.getLicensenumber(), res.getLicensenumber());
        Assert.assertSame(r.getFullname(), res.getFullname());
    }

}
