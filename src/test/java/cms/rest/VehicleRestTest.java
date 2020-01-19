package cms.rest;

import cms.model.Regularuser;
import cms.model.Shipment;
import cms.model.Vehicle;
import cms.service.RegularuserService;
import cms.service.VehicleService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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


public class VehicleRestTest extends BaseRestTestRunner {

    @Mock
    private VehicleService vehicleServiceMock;



    @InjectMocks
    private VehicleController sut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        super.setUp(sut);
    }

    @Test
    public void getByIdReturnsMatchingVehicle() throws Exception {
        final Vehicle v = new Vehicle();
        v.setLicenseplate("kokot");
        when(vehicleServiceMock.find(v.getLicenseplate())).thenReturn(v);
        final MvcResult mvcResult = mockMvc.perform(get("/rest/vehicle/" + v.getLicenseplate())).andReturn();

        final Vehicle result = readValue(mvcResult, Vehicle.class);
        assertNotNull(result);
        assertEquals(v.getLicenseplate(), result.getLicenseplate());
    }


}
