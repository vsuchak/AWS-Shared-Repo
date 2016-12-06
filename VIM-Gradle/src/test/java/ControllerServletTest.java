import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.ControllerServlet;
import com.cg.beans.CarDTO;
import com.cg.dao.CarDAO;

public class ControllerServletTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private CarDAO carDAORef;
	
	@Before
	public void setup(){
//		PREPARE MOCK OBJECTS FOR CarDAO and HttpServletRequest
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		carDAORef = Mockito.mock(CarDAO.class);
	}
	
	
	@Test
	public void testProcessRequest() throws ServletException, IOException {
//		fail("Not yet implemented");
		
//		-----------------SETUP----------------------
//		PREPARE STUB FOR getParameter() ON HttpServletRequest
//		EXPECTED RETUENED VALUES IS 'viewCars"
		
		Mockito.when(request.getParameter("action")).thenReturn("viewCarList");
		
//		PREPARE STUB FOR findAll() ACTION ON CarDAO;
//		EXPECTED RETUENED VALUE IS LIST OF CarDTO
		
//		DATA fixture
		List<CarDTO> cars = new LinkedList<CarDTO>();
		
		CarDTO car1 = new CarDTO();
		car1.setId(1);
		car1.setMake("Honda");
		car1.setModel("City");
		car1.setModelYear("2015");
		cars.add(car1);
		
		Mockito.when(carDAORef.findAll()).thenReturn(cars);

		
		
//		-----------------EXECUTION----------------------
//		PERFORM ACTUAL EXECUTION OF processRequest on HttpServlet object

		ControllerServlet myServlet = new ControllerServlet();
//		MockitoAnnotations.initMocks(myServlet);
		myServlet.setCarDAO(carDAORef);
		myServlet.processRequest(request, response);
		
//		-----------------VERIFICATION----------------------
//		VERIFY STUBS WERE ACTUALLY INVOKED DURING EXECUTION

		Mockito.verify(request).getParameter("action");
		Mockito.verify(carDAORef).findAll();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
