package cms.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
public class RegularuserTest {
    @Test
    public void creatingRegularuser() {
        final Regularuser user = new Regularuser();
        user.setUsername("123456");
        user.setFullname("Eleonora Kasaiova");
        user.setPassword("123");

        assertEquals(user.getUsername(), "123456");
        assertEquals(user.getFullname(), "Eleonora Kasaiova");
        assertEquals(user.getPassword(), "123");

        user.setUsername("654321");
        assertEquals("654321", user.getUsername());
    }
}
