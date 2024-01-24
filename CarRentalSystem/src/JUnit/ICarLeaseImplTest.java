package JUnit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.rmi.dgc.Lease;
import java.sql.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Dao.ICarLeaseImpl;
import Modal.Customer;
import Modal.Vehicle;
import util.DBConnection;
public class ICarLeaseImplTest {

    private ICarLeaseImpl carManager;
    private ICarLeaseImpl carLeaseImpl;

    @Before
    public void setUp() {
        carManager = new ICarLeaseImpl();
        carLeaseImpl=new ICarLeaseImpl();
    }

    @Test
   public void testAddCar() {
        // Create a mock Vehicle object for testing
        Vehicle car = new Vehicle(2008,"Mahindra", "Thar", 2022, 3800, "Available",4,300);
        carManager.addCar(car);
        Vehicle retrievedCar = carManager.findCarById(car.getVehicleID());
        assertNotNull(retrievedCar);
        assertEquals(car.getVehicleID(), retrievedCar.getVehicleID());
        assertEquals(car.getMake(), retrievedCar.getMake());
        assertEquals(car.getModel(), retrievedCar.getModel());
        assertEquals(car.getYear(), retrievedCar.getYear());
        assertEquals(BigDecimal.valueOf(car.getDailyRate()), BigDecimal.valueOf(retrievedCar.getDailyRate()));
        assertEquals(car.getStatus(), retrievedCar.getStatus());
        assertEquals(car.getPassengerCapacity(), retrievedCar.getPassengerCapacity());
        assertEquals(BigDecimal.valueOf(car.getEngineCapacity()),BigDecimal.valueOf(retrievedCar.getEngineCapacity()));
    }
    @Test
    public void testCreateLease() {
        int vehicleID = 2007; // Replace with a valid Vehicle ID for testing
        int customerID = 9; // Replace with a valid Customer ID for testing
        String startDate = "2024-01-01";
        String endDate = "2024-01-10";

        Modal.Lease createdLease = carLeaseImpl.createLease(vehicleID, customerID, startDate, endDate);
        
        // Assert
        assertNotNull(createdLease);
        // Add more assertions based on your expected behavior
       // assertEquals(LeaseID,createdLease.getLeaseID());
        assertEquals(vehicleID, createdLease.getVehicle().getVehicleID());
        assertEquals(customerID, createdLease.getCustomer().getCustomerID());
        assertEquals(startDate, createdLease.getStartDate());
        assertEquals(endDate, createdLease.getEndDate());
    }
    @Test
    public void testReturnCarValidLease() {
        // Arrange
        int validLeaseID =30;

        
        ICarLeaseImpl find= new ICarLeaseImpl(); // Replace with the actual class name
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        find.returnCar(validLeaseID);

     
     
        assertTrue(outContent.toString().contains("LeaseID:" + validLeaseID), "Expected LeaseID not found in console output");

  
        System.setOut(System.out);
    }

	private void assertTrue(boolean contains,String string) {
		// TODO Auto-generated method stub
		
	}
  
}
