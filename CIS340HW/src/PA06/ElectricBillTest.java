package PA06;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;
import java.util.Arrays;


//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA06 										  *
//* 																  *
//*  PA06			  				  								  *
//* 																  *
//* Date Created: 04.05.2018					    			      *
//* Saved in: ElectricBillTest.java  								  *
//* 																  *
//*********************************************************************
//
public class ElectricBillTest {
	
	
	private static Customer[] customers;
	private static String fileName;
	

public static void main(String[] args) {
	// declare variables and constants
	int noOfKHW = 0;
	String fName = "";
	String lName = "";
	int custNumber = 0;
	int custType=0;
	int noOfCust=0;	
	int billMonth=0;
	
	int stop = JOptionPane.YES_OPTION;
	
			
	// read the number of customers
	while (stop==JOptionPane.YES_OPTION){
		try {
			noOfCust=Integer.parseInt(JOptionPane.showInputDialog("Number of Customers."));
			if (noOfCust<0)
				throw new Exception();
			break;
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Values must be above zero.");
			stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
			if (stop!=JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Exit Program");
				System.exit(0);
			}
			continue;
		}
	}
	// initilize the array
	customers=new Customer[noOfCust];
		
	// read customer data
	for(int i=0; i<noOfCust; i++) {
		// real Input
		while (stop==JOptionPane.YES_OPTION){
			try {
				custNumber=Integer.parseInt(JOptionPane.showInputDialog("Enter customer ID: "));
				if (custNumber<10000000 || custNumber>99999999)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Wrong customer ID." , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		while (stop==JOptionPane.YES_OPTION){
			try {
				custType=Integer.parseInt(JOptionPane.showInputDialog("Type of customer (0 for Residential; 1 for Commercial): "));
				if (custType != 0 && custType != 1)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Wrong type of customer. (0 for Residential; 1 for Commercial) " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		while (stop==JOptionPane.YES_OPTION){
			try {
				fName=JOptionPane.showInputDialog("Name of the customer - First Name: ");
				if (fName=="")
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Blank Name!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the name?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		while (stop==JOptionPane.YES_OPTION){
			try {
				lName=JOptionPane.showInputDialog("Name of the customer - Last Name: ");
				if (lName=="")
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Blank Name!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the name?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		while (stop==JOptionPane.YES_OPTION){
			try {
				noOfKHW=Integer.parseInt(JOptionPane.showInputDialog("Energy usage (kWh decimal value): "));
				if (noOfKHW<=0)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Invalid value!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		while (stop==JOptionPane.YES_OPTION){
			try {
				billMonth=Integer.parseInt(JOptionPane.showInputDialog("Month for the bill (1 for Jan, 2 for Feb, etc): "));
				if (billMonth>12 || billMonth<1)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Invalid month!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter month?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
	// create a bill object based on the customer status: residential or commercial
	// add customer object to the customers array using addCustomer() method\
		addCustomer(custNumber, fName, lName, custType, noOfKHW, billMonth);
	}
	
	
	
	// sort bills based on bill amount
	sortArray();
	
	// display bill objects
	display();
	// write bill objects to file
	writeToFile();
}


public static double getSum(){
	// finds the sum of the customers bills
	double sum=0.0;
	ElectricBill temp;
	for(int i=0; i<Customer.getNumberOfCustomers(); i++){
		temp=customers[i].getBill();
		sum+=temp.getBillAmount();
	}
	return sum;
}


public static double getAvg(){
	// finds the average of the customers bills
	double sum=getSum();
	double avg=sum/Customer.getNumberOfCustomers();
	return avg;
}


public static void addCustomer(int custNumber, String fName, String lName, int custType, int noOfKWH,int billMonth){
	// add a new customer object to the customers array
	// you must double check the array size before adding a new customer to the array
	if(Customer.getNumberOfCustomers()<customers.length){
		if(custType==1) 
			customers[Customer.getNumberOfCustomers()]= new Customer(custNumber, fName, lName, custType, new Residential(noOfKWH, billMonth)); 
		else
			customers[Customer.getNumberOfCustomers()]= new Customer(custNumber, fName, lName, custType, new Commercial(noOfKWH, billMonth));
	} else 
		JOptionPane.showMessageDialog(null, "The Array is Full");
}

public static void sortArray(){
	// use the selection sort to sort the arrays based on bill amount
	Arrays.sort(customers);
}

public static void writeToFile(){
	// write bill objects to file
	String fileOutput="";
	fileName="customers.txt";
	while (0<1){
	    java.io.File file = new java.io.File(fileName);
	    if (file.exists()) {
	      System.out.println("File already exists");
	      fileName+=" - 1";
	    }
	    break;
	}
    java.io.PrintWriter outputFile = null;
    // Create a file
    try {
		outputFile = new java.io.PrintWriter(fileName);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
    
    for(int i = 0; i < customers.length; i++){
    	
    	fileOutput +=  customers[i].toString() + "\n";			   

		}
		
    //Write to File    
	outputFile.print(fileOutput);

    //Close the File
    outputFile.close();

}//end of writeToFile()

public static void display(){
	// display bill objects
	String output="CustomerID\tFirstName\tLastName\tCust-Status\tNoOfKWH\tMonth\tBillAmount\n";
	for(int i=0;i<customers.length;i++) {
		output+=customers[i].toString()+"\n";
	}
	output+="\nSum of Bill Amount: " + String.format("%.2f", getSum()) + "\tAverage Bill Amount: "
			+ String.format("%.2f", getAvg());
	
	JOptionPane.showMessageDialog(null, new JTextArea (output),
			"WATERBILL",JOptionPane.INFORMATION_MESSAGE);
}


}
