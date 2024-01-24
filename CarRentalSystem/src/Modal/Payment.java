package Modal;

import java.sql.Date;

public class Payment 
{
private int paymentID;
private Lease leaseID;
private String paymentDate;
private double amount;
public Payment(int paymentID, Lease leaseID,String paymentDate, double amount) {
	this.paymentID = paymentID;
	this.leaseID = leaseID;
	this.paymentDate = paymentDate;
	this.amount = amount;
	
}
public int getPaymentID() {
	return paymentID;
}
public void setPaymentID(int paymentID) {
	this.paymentID = paymentID;
}
public Lease getLeaseID() {
	return leaseID;
}
public void setLeaseID(Lease leaseID) {
	this.leaseID = leaseID;
}
public String getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(String paymentDate) {
	this.paymentDate = paymentDate;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Payment [paymentID=" + paymentID + ", leaseID=" + leaseID + ", paymentDate=" + paymentDate + ", amount="
			+ amount + "]";
}


}

