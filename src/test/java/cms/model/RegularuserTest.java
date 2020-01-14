package cms.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
public class RegularuserTest {
    @Test
    public void addCategoryWorksWhenAddingCategoryForFirstTime() {
        final Regularuser user = new Regularuser();
        user.setUsername("123456");
        user.setFullname("Kokot pojebany");
        user.setPassword("123");

        assertEquals(user.getUsername(), "123456");
        assertEquals(user.getFullname(), "Kokot pojebany");
        assertEquals(user.getPassword(), "123");
    }
}
