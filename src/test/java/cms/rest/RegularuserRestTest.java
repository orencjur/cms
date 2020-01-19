package cms.rest;

import cms.model.Regularuser;
import cms.model.Shipment;
import cms.service.RegularuserService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class RegularuserRestTest extends BaseRestTestRunner {

    @Mock
    private RegularuserService regularuserServiceServiceMock;



    @InjectMocks
    private RegularuserController sut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        super.setUp(sut);
    }

    @Test
    public void getAllReturnsUsersReadByRegualuserService() throws Exception {
        final List<Regularuser> users = IntStream.range(0, 5).mapToObj(i -> {
            final Regularuser reg = new Regularuser();
            reg.setUsername("user" + i);
            return reg;
        }).collect(Collectors.toList());
        when(regularuserServiceServiceMock.findAll()).thenReturn(users);

        final MvcResult mvcResult = mockMvc.perform(get("/rest/regularuser")).andReturn();
        final List<Regularuser> result = readValue(mvcResult, new TypeReference<List<Regularuser>>() {
        });
        assertEquals(users.size(), result.size());
        verify(regularuserServiceServiceMock).findAll();
    }

    @Test
    public void getByIdReturnsMatchingRegularuser() throws Exception {
        final Regularuser reg = new Regularuser();
        reg.setUsername("kokot");
        when(regularuserServiceServiceMock.find(reg.getUsername())).thenReturn(reg);
        final MvcResult mvcResult = mockMvc.perform(get("/rest/regularuser/" + reg.getUsername())).andReturn();

        final Regularuser result = readValue(mvcResult, Regularuser.class);
        assertNotNull(result);
        assertEquals(reg.getUsername(), result.getUsername());
    }



}
