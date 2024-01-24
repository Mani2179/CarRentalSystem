package Modal;

import java.sql.Date;

public class Lease 
{
private int leaseID;
private Vehicle vehicle;
private Customer customer;
private String startDate;
private String endDate;
private String type;
public Lease(int leaseID, Vehicle vehicle, Customer customer,String startDate,String endDate, String type) 
{
	this.leaseID = leaseID;
	this.vehicle = vehicle;
	this.customer = customer;
	this.startDate = startDate;
	this.endDate = endDate;
	this.type = type;
}
public int getLeaseID() {
	return leaseID;
}
public void setLeaseID(int leaseID) {
	this.leaseID = leaseID;
}
public Vehicle getVehicle() {
	return vehicle;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "Lease [leaseID=" + leaseID + ", vehicle=" + vehicle + ", customer=" + customer + ", startDate=" + startDate
			+ ", endDate=" + endDate + ", type=" + type + "]";
}

}
