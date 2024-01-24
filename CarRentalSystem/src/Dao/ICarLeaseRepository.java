package Dao;

import java.util.Date;
import java.util.List;

import Modal.*;
import exception.*;

public interface ICarLeaseRepository 
{
void addCar(Vehicle car);
void removeCar(int VehicleID);
List<Vehicle>listAvailableCars();
List<Vehicle>listRentedCars();
Vehicle findCarById(int VehicleID) throws CarNotFoundException ;
void addCustomer(Customer customer);
void removeCustomer(int CustomerID);
List<Customer>listCustomers();
Customer findCustomerById(int customerid) throws CustomerNotFoundException;
Lease createLease(int VehicleID,int CustomerID,String startDate,String endDate);
void returnCar(int leaseID);
List<Lease>listActiveLease();
List<Lease>listLeaseHistory();
void recordPayment(int LeaseID);
}
