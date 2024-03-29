package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Dao.*;
import Modal.*;

public class Main {
	public static void main(String[] args)
	{ 
		Scanner sc=new Scanner(System.in);
	   System.out.println("1.Vehicle");
      System.out.println("2.Customer");
      System.out.println("3.Lease");
      System.out.println("4.Payments");
      System.out.println("5.exit");
      System.out.println("Enter your Choice:");
      int ch=sc.nextInt();
      switch(ch)
      {
      case 1:
    	  System.out.println("Vehicle Table");
    	  vehicleManagement();
    	  break;
      case 2:
    	  System.out.println("Customer Table");
    	  customerManagement();
    	  break;
      case 3:
    	  System.out.println("Lease");
    	  LeaseManagement();
    	  break;
      case 4:
    	  System.out.println("Payments");
    	  paymentManagement();
    	  break;
      case 5:
    	  System.out.println("Exiting.....");
    	  
    	  break;
    	  default :
    		  System.out.println("Invalid choice");
    		  break;
      }
	}
	
	public static void vehicleManagement()
	{
		Scanner sc=new Scanner(System.in);
		ICarLeaseImpl icl=new ICarLeaseImpl();
		System.out.println("Enter Vehicle Details");
		System.out.println("1.Enter New Car into Vehicles Table");
		System.out.println("2.Remove the Car");
		System.out.println("3.List Available Cars");
		System.out.println("4.ListRented Cars");
		System.out.println("5.Find Vehicle BY ID"); 
        System.out.println("6.Exit");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter VehicleID");
			int vehicleID=sc.nextInt();
			System.out.println("Enter VehicleMake");
            String make=sc.next();
			System.out.println("Enter VehicleModel");
            String model=sc.next();
			System.out.println("Enter VehicleYear");
            int year=sc.nextInt();
            System.out.println("Enter DailyRate");
            double DailyRate=sc.nextDouble();
            System.out.println("Enter status of vehicle");
            String status=sc.next();
            System.out.println("Enter passengerCapacity");
            int passengerCapacity=sc.nextInt();
            System.out.println("Enter engine capacity");
            double engineCapacity=sc.nextDouble();
            Vehicle car;
            car=new Vehicle(vehicleID,make,model,year,DailyRate,status,passengerCapacity,engineCapacity);
            icl.addCar(car);
			break;
		case 2:
			System.out.println("Enter vehicle ID to remove the car:");
			System.out.println("Enter VehivleID");
			int VehicleID=sc.nextInt();
			icl.removeCar(VehicleID);
			break;
		case 3:
			System.out.println("Listing all available cars");
			icl.listAvailableCars();
			List<Vehicle> v=icl.listAvailableCars();
			//System.out.println(v);
			for(Vehicle veh: v)
			{
				    System.out.println("Vehicle ID: " + veh.getVehicleID());
			        System.out.println("Make: " + veh.getMake());
			        System.out.println("Model: " + veh.getModel());
			        System.out.println("Year: " + veh.getYear());
			        System.out.println("DailyRate: " + veh.getDailyRate());
			        System.out.println("status: " + veh.getStatus());
			        System.out.println("passengerCapacity: " + veh.getPassengerCapacity());
			        System.out.println("engineCapacity: " + veh.getEngineCapacity());
			        System.out.println("------------------------");
			}
			break;
		case 4:
			System.out.println("Listing all Rented cars");
			icl.listAvailableCars();
			List<Vehicle> vehicleList=icl.listRentedCars();
			for(Vehicle veh: vehicleList)
			{
				    System.out.println("Vehicle ID: " + veh.getVehicleID());
			        System.out.println("Make: " + veh.getMake());
			        System.out.println("Model: " + veh.getModel());
			        System.out.println("Year: " + veh.getYear());
			        System.out.println("DailyRate: " + veh.getDailyRate());
			        System.out.println("status: " + veh.getStatus());
			        System.out.println("passengerCapacity: " + veh.getPassengerCapacity());
			        System.out.println("engineCapacity: " + veh.getEngineCapacity());
			        System.out.println("------------------------");
			}
			break;
		case 5:
			System.out.println("Finding the car by id");
			System.out.println("Enter VehicleID");
			int vehicleid=sc.nextInt();
			Vehicle vo=icl.findCarById(vehicleid);
				    System.out.println("Vehicle ID: " + vo.getVehicleID());
			        System.out.println("Make: " + vo.getMake());
			        System.out.println("Model: " + vo.getModel());
			        System.out.println("Year: " + vo.getYear());
			        System.out.println("DailyRate: " + vo.getDailyRate());
			        System.out.println("status: " + vo.getStatus());
			        System.out.println("passengerCapacity: " + vo.getPassengerCapacity());
			        System.out.println("engineCapacity: " + vo.getEngineCapacity());
			        System.out.println("------------------------");
			        break;
		case 6:
			System.out.println("Exiting.....");
			break;
			default:
				System.out.println("Invalid choice");
				break;
		}
		
	}
	public static void customerManagement()
	{
		Scanner sc=new Scanner(System.in);
		ICarLeaseImpl icl=new ICarLeaseImpl();
	
		System.out.println("Enter Customer Details");
		System.out.println("1.Enter customer");
		System.out.println("2.remove customer");
		System.out.println("3.List customers");
		System.out.println("4.Find Customer BY ID");
		System.out.println("5.Exit");
		System.out.println("Enter Choice");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter CustomerID:");
			int customerID=sc.nextInt();
			System.out.println("Enter FirstName:");
			String firstName=sc.next();
			System.out.println("Enter LastName:");
			String lastName=sc.next();
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter PhoneNumber:");
			long phoneNumber=sc.nextLong();
			Customer customer;
			customer=new Customer(customerID,firstName,lastName,email,phoneNumber);
			icl.addCustomer(customer);
			break;
		case 2:
			System.out.println("remove Customer");
			System.out.println("Enter CustomerID");
			int CustomerID=sc.nextInt();
			icl.removeCustomer(CustomerID);
			break;
		case 3:
			System.out.println("Listing Customers");
			icl.listCustomers();
			List<Customer> cust = icl.listCustomers();

		    for (Customer custo : cust) {
		        System.out.println("Customer ID: " + custo.getCustomerID());
		        System.out.println("First Name: " + custo.getFirstName());
		        System.out.println("Last Name: " + custo.getLastName());
		        System.out.println("Email: " + custo.getEmail());
		        System.out.println("Phone Number: " + custo.getPhone());
		        System.out.println("------------------------");
		    }
			break;
		case 4:
			System.out.println("finding customer");
			System.out.println("Enter CustomerID");
			int customerid=sc.nextInt();
			Customer cust1=icl.findCustomerById(customerid);
			System.out.println("Customer ID: " + cust1.getCustomerID());
	        System.out.println("First Name: " + cust1.getFirstName());
	        System.out.println("Last Name: " + cust1.getLastName());
	        System.out.println("Email: " + cust1.getEmail());
	        System.out.println("Phone Number: " + cust1.getPhone());
	        System.out.println("------------------------");
			break;
		case 5:
			System.out.println("Exiting....");
			break;
			default :
				System.out.println("Invalid choice");
				break;
	}
	}
	
	
		public static void  LeaseManagement() 
		{
			Scanner sc=new Scanner(System.in);
			ICarLeaseImpl icl=new ICarLeaseImpl();
			System.out.println("1.Create Lease");
			System.out.println("2.Return Car Details By LeaseID");
			System.out.println("3.List Active Leases");
			System.out.println("4.List Lease History");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				System.out.println("Enter CustomerID:");
				int CustomerID=sc.nextInt();
				System.out.println("Enter CarID");
				int VehicleID=sc.nextInt();
				System.out.println("Enter statt Date");
				String startDate=sc.next();
				System.out.println("Enter End Date");
			    String endDate=sc.next();
				Lease lease=icl.createLease(VehicleID,CustomerID,startDate,endDate);
				System.out.println("LEASEID:"+lease.getLeaseID());
				System.out.println("Customer ID:"+lease.getCustomer().getCustomerID());
				System.out.println("Customer Name:"+lease.getCustomer().getFirstName()+" "+lease.getCustomer().getLastName());
				System.out.println("Customer Email:"+lease.getCustomer().getEmail());
				System.out.println("Customer Phone:"+lease.getCustomer().getPhone());
				System.out.println("VehicleID:  "+lease.getVehicle().getVehicleID());
				System.out.println("Vehiclec Make:  "+lease.getVehicle().getMake());
				System.out.println("Vehicle Model:  "+lease.getVehicle().getModel());
				System.out.println("Vehicle Year: "+lease.getVehicle().getYear());
				System.out.println("Vehicle DailyRate:  "+lease.getVehicle().getDailyRate());
		
				System.out.println("Vehicle Capacity: "+lease.getVehicle().getPassengerCapacity());
				System.out.println(lease.getVehicle().getEngineCapacity());
				System.out.println(lease.getType());

				break;
			case 2:
				System.out.println("Enter leaseID");
				int leaseID=sc.nextInt();
				icl.returnCar(leaseID);
				break;
			case 3:
				System.out.println("List Active Leases");
				List<Lease>le=icl.listActiveLease();
				for(Lease l:le)
				{
					System.out.println("LEASEID:"+l.getLeaseID());
					System.out.println("Customer ID:"+l.getCustomer().getCustomerID());
					System.out.println("Customer Name:"+l.getCustomer().getFirstName()+" "+l.getCustomer().getLastName());
					System.out.println("Customer Email:"+l.getCustomer().getEmail());
					System.out.println("Customer Phone:"+l.getCustomer().getPhone());
					System.out.println("VehicleID:  "+l.getVehicle().getVehicleID());
					System.out.println("Vehiclec Make:  "+l.getVehicle().getMake());
					System.out.println("Vehicle Model:  "+l.getVehicle().getModel());
					System.out.println("Vehicle Year: "+l.getVehicle().getYear());
					System.out.println("Vehicle DailyRate:  "+l.getVehicle().getDailyRate());
					System.out.println(l.getVehicle().getStatus());
					System.out.println("Vehicle Capacity: "+l.getVehicle().getPassengerCapacity());
					System.out.println(l.getVehicle().getEngineCapacity());
					System.out.println("StartDate: "+l.getStartDate());
					System.out.println("EndDate: "+l.getEndDate());
					System.out.println("LeaseType: "+l.getType());
					System.out.println("----------------------------------");
				}
				break;
			case 4:
				//icl.listLeaseHistory();
				List<Lease>lea=icl.listLeaseHistory();
				for(Lease l:lea)
				{
					System.out.println("LEASEID:"+l.getLeaseID());
					System.out.println("Customer ID:"+l.getCustomer().getCustomerID());
					System.out.println("Customer Name:"+l.getCustomer().getFirstName()+" "+l.getCustomer().getLastName());
					System.out.println("Customer Email:"+l.getCustomer().getEmail());
					System.out.println("Customer Phone:"+l.getCustomer().getPhone());
					System.out.println("VehicleID:  "+l.getVehicle().getVehicleID());
					System.out.println("Vehiclec Make:  "+l.getVehicle().getMake());
					System.out.println("Vehicle Model:  "+l.getVehicle().getModel());
					System.out.println("Vehicle Year: "+l.getVehicle().getYear());
					System.out.println("Vehicle DailyRate:  "+l.getVehicle().getDailyRate());
					System.out.println(l.getVehicle().getStatus());
					System.out.println("Vehicle Capacity: "+l.getVehicle().getPassengerCapacity());
					System.out.println(l.getVehicle().getEngineCapacity());
					System.out.println("StartDate: "+l.getStartDate());
					System.out.println("EndDate: "+l.getEndDate());
					System.out.println("LeaseType: "+l.getType());
					System.out.println("----------------------------------");				}
				break;
			case 5:
				System.out.println("Invalid choice");
				break;
			default :
				break;
			}
		}
			
			
		public static void paymentManagement()
		{
			Scanner sc=new Scanner(System.in);
			ICarLeaseImpl icl=new ICarLeaseImpl();
			System.out.println("Enter LeaseID:");
			int LeaseID=sc.nextInt();
			//double amount=sc.nextDouble();
            icl.recordPayment(LeaseID);
		}

}
	

