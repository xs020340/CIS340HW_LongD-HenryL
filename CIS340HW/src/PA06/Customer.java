package PA06;

//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA06 										  *
//* 																  *
//*  PA06			  				  								  *
//* 																  *
//* Date Created: 04.05.2018					    			      *
//* Saved in: Customer.java  										  *
//* 																  *
//*********************************************************************
//
public class Customer implements Comparable<Customer>{

	private int customerID;
	private String fName;
	private String lName;
	private int status;
	private ElectricBill bill;
	private static int numberOfCustomers = 0;
	
	public Customer(int customerID, String fName, String lName, int status, ElectricBill bill) {
		this.customerID = customerID;
		this.fName = fName;
		this.lName = lName;
		this.status = status;
		this.bill = bill;
		numberOfCustomers++;
	}


	// add the class overloaded constructor
	public Customer() {
		this.customerID = 0;
		this.fName = "";
		this.lName = "";
		this.status = 0;
		this.bill = null;
		numberOfCustomers=0;
	}



	// add setter and getter methods

	public int getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public ElectricBill getBill() {
		return bill;
	}



	public void setBill(ElectricBill bill) {
		this.bill = bill;
	}



	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}



	public static void setNumberOfCustomers(int numberOfCustomers) {
		Customer.numberOfCustomers = numberOfCustomers;
	}



	@Override
	public String toString() {
		String statusStr="";
		switch (status) {
		case 0:
			statusStr="Residential";
			break;
		case 1:
			statusStr="Commercial";
			break;
		}
		return customerID + "\t" + fName + "\t" + lName + "\t" + statusStr
				+ "\t" + bill.toString();
	}



	@Override
	public int compareTo(Customer cust) {
		if(this.bill.getBillAmount()>cust.bill.getBillAmount())
			return 1;
		else if (this.bill.getBillAmount()<cust.bill.getBillAmount())
			return -1;
		else
			return 0;
	}
	
	// override the toString() method


}
