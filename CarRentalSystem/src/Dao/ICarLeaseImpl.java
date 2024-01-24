package Dao;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Modal.*;
import exception.CarNotFoundException;
import exception.CustomerNotFoundException;
import exception.LeaseNotFoundException;
import util.*;
public class ICarLeaseImpl implements ICarLeaseRepository 
{


	@Override
	public void addCar(Vehicle car) {
		// TODO Auto-generated method stub
		DBConnection c=new DBConnection();
		int vehicleID=car.getVehicleID();
		String make=car.getMake();
		String model=car.getModel();
		int year=car.getYear();
		double Rate=car.getDailyRate();
		String status=car.getStatus();
		int passengers=car.getPassengerCapacity();
		double engine=car.getEngineCapacity();
		String query="insert into Vehicle values('"+vehicleID+"','"+make+"','"+model+"','"+year+"','"+Rate+"','"+status+"','"+passengers+"','"+engine+"')";
		try
		{
			c.s.executeUpdate(query);
			System.out.println("Record inserted successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void removeCar(int VehicleID) 
	{
		// TODO Auto-generated method stub
		DBConnection c=new DBConnection();
		String query="delete from Lease where VehicleID='"+VehicleID+"'";
		String query1="delete from vehicle where VehicleID='"+VehicleID+"'";
		try
		{
		   c.s.executeUpdate(query1);
		   System.out.println("Car Deleted");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public List<Vehicle> listAvailableCars() {
		
			List<Vehicle> v=new ArrayList<>();
		DBConnection c=new DBConnection();
		String query="select * from Vehicle where status='available'";
		try
		{
		ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				v.add(new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("Year"),rs.getDouble("DailyRate"),rs.getString("status"),rs.getInt("passengerCapacity"),rs.getDouble("engineCapacity")));
			}
			System.out.println("After connection");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return v;
	}

	@Override
	public List<Vehicle> listRentedCars() {
		// TODO Auto-generated method stub
		List<Vehicle> ve=new ArrayList<>();
		DBConnection c=new DBConnection();
		String query="select * from Vehicle where status='not_available'";
		try
		{
		ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				ve.add(new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("Year"),rs.getDouble("DailyRate"),rs.getString("status"),rs.getInt("passengerCapacity"),rs.getDouble("engineCapacity")));
			}
			System.out.println("After connection");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return ve;
	}

	@Override
	public Vehicle findCarById(int VehicleID){
		// TODO Auto-generated method stub
		Vehicle v = null;
		DBConnection c=new DBConnection();
		String query="select * from Vehicle where VehicleID='"+VehicleID+"'";
		try
		{
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				v=new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("Year"),rs.getDouble("DailyRate"),rs.getString("status"),rs.getInt("passengerCapacity"),rs.getDouble("engineCapacity"));
			}
			else
			{
			throw new CarNotFoundException("No car with specific id");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return v;
	}

	@Override
	public void addCustomer(Customer customer)
	{
		// TODO Auto-generated method stub
	  DBConnection c=new DBConnection();
		int CID=customer.getCustomerID();
		String FName=customer.getFirstName();
		String LName=customer.getLastName();
		String Email=customer.getEmail();
		long PNumber=customer.getPhone();
		String query="insert into Customer values('"+CID+"','"+FName+"','"+LName+"','"+Email+"','"+PNumber+"')";
		try
		{
			c.s.executeUpdate(query);
			System.out.println("Record inserted successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void removeCustomer(int CustomerID) 
	{
		// TODO Auto-generated method stub
		DBConnection c=new DBConnection();
		String query="delete from Lease where CustomerID='"+CustomerID+"'";
		String query1="delete from Customer where CustomerID='"+CustomerID+"'";
		try
		{
			c.s.executeUpdate(query);
			c.s.executeUpdate(query1);
			System.out.println("Record deleted successfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Customer> listCustomers() 
	{
		DBConnection c=new DBConnection();
		String query="select * from Customer";
		List<Customer>cust=new ArrayList<>();
		try
		{
			ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
				cust.add(new Customer(rs.getInt("CustomerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("email"),rs.getLong("PhoneNumber")));
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		return cust;
	}

	@Override
	public Customer findCustomerById(int customerid){
		// TODO Auto-generated method stub
		Customer cust1=null;
		DBConnection c=new DBConnection();
		String query="select * from Customer where CustomerID='"+customerid+"'";
		try
		{
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				System.out.println("valid user");
				cust1=new Customer(rs.getInt("CustomerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("email"),rs.getLong("PhoneNumber"));
			}
			else
			{
				throw new CustomerNotFoundException("Customer not available");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return cust1;
	}

	@Override
	public Lease createLease(int VehicleID,int CustomerID,String startDate,String endDate)
	{
		Conn c=new Conn();
		Lease lease=null;
		LocalDate sDate=LocalDate.parse(startDate);
		LocalDate eDate=LocalDate.parse(endDate);
		long diff=ChronoUnit.DAYS.between(sDate, eDate);
		String type=null;
		if(diff>30)
		{
			type="Monthly";
		}
		else
		{
			type="Daily";
		}
		System.out.println(type);
		String query = "INSERT INTO Lease (vehicleID,CustomerID, startDate, endDate, type) VALUES ('" +VehicleID + "','" +CustomerID + "','" + startDate + "','" + endDate + "','" + type + "')";
		String query2="Update vehicle set status='not_available' where VehicleID='"+VehicleID+"'";
		String query1="select * from Lease l inner join Customer c ON l.CustomerID=c.CustomerID Inner Join Vehicle v ON l.VehicleID=v.VehicleID where l.customerID='"+CustomerID+"' AND l.vehicleID='"+VehicleID+"'";
		try
		{
			c.s.executeUpdate(query);
			c.s.executeUpdate(query2);
			ResultSet rs=c.s.executeQuery(query1);
			//c.s.executeUpdate(query2);
			while(rs.next())
			{
				Customer customer=new Customer(rs.getInt("CustomerID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getLong("PhoneNumber"));
				Vehicle vehicle=new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("year"),rs.getDouble("dailyRate"),rs.getString("status"),rs.getInt("PassengerCapacity"),rs.getDouble("engineCapacity"));
			lease=new Lease(rs.getInt("LeaseID"),vehicle,customer,rs.getString("startDate"),rs.getString("EndDate"),rs.getString("type"));	
			}
			System.out.println("Lease Created");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return lease;
	}

	@Override
	public void returnCar(int leaseID) {
		// TODO Auto-generated method stub
		DBConnection c=new DBConnection();
		String query="select * from Lease l INNER JOIN Vehicle v ON l.VehicleID=v.VehicleID where l.LeaseID='"+leaseID+"'";
		try
		{
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				System.out.println("LeaseID:"+rs.getInt("LeaseID"));
				System.out.println("VehicleID:"+rs.getInt("VehicleID"));
				System.out.println("Make:"+rs.getString("Make"));
				System.out.println("Model:"+rs.getString("Model"));	
				System.out.println("StartDate:"+rs.getString("startDate"));		
				System.out.println("EndDate:"+rs.getString("EndDate"));			
				}
			else
			{
				throw new LeaseNotFoundException("No lease found this lease ID");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Lease> listActiveLease() {
		Conn c=new Conn();
		String query="select * from Lease l Inner join Vehicle v ON l.VehicleID=v.VehicleID Inner Join Customer c ON l.CustomerID=c.CustomerID where startDate<=CURDATE() AND endDate>=CURDATE()";
		List<Lease> lease=new ArrayList<>();
		try
		{
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				Customer customer=new Customer(rs.getInt("CustomerID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getLong("PhoneNumber"));
				Vehicle vehicle=new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("year"),rs.getDouble("dailyRate"),rs.getString("status"),rs.getInt("PassengerCapacity"),rs.getDouble("engineCapacity"));
				lease.add(new Lease(rs.getInt("LeaseID"),vehicle,customer,rs.getString("startDate"),rs.getString("EndDate"),rs.getString("type")));
			}
			
			System.out.println("Retrival success");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return lease;
	}

	@Override
	public List<Lease> listLeaseHistory() {
		List<Lease> lease=new ArrayList<>();
		DBConnection c=new DBConnection();
		String query="select * from Lease l Inner join Vehicle v ON l.VehicleID=v.VehicleID Inner Join Customer c ON l.CustomerID=c.CustomerID";
		try
		{
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				Customer customer=new Customer(rs.getInt("CustomerID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getLong("PhoneNumber"));
				Vehicle vehicle=new Vehicle(rs.getInt("VehicleID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("year"),rs.getDouble("dailyRate"),rs.getString("status"),rs.getInt("PassengerCapacity"),rs.getDouble("engineCapacity"));
				lease.add(new Lease(rs.getInt("LeaseID"),vehicle,customer,rs.getString("startDate"),rs.getString("EndDate"),rs.getString("type")));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return lease;
	}

	@Override
	public void recordPayment(int LeaseID) {
		DBConnection c=new DBConnection();
		String query = "INSERT INTO payment (leaseID) VALUES ("+LeaseID +")";
		String query1="UPDATE payment AS p INNER JOIN lease AS l ON p.LeaseID = l.LeaseID INNER JOIN vehicle AS v ON l.VehicleID = v.VehicleID SET p.amount = (DATEDIFF(CURDATE(), l.startDate) + 1) * v.DailyRate,p.PaymentDate=CURDATE() WHERE p.LeaseID ='"+LeaseID+"'";
		try
		{
			c.s.executeUpdate(query);
			c.s.executeUpdate(query1);
			System.out.println("Payment created");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
