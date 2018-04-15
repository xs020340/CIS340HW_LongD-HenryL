//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Henry Liu  									  *
//* 																  *
//* Program Assignment PA07 										  *
//* 																  *
//*  PA07			  				  								  *
//* 																  *
//* Date Created: 04.15.2018					    			      *
//* Saved in: UserGUI.java  										  *
//* 																  *
//*********************************************************************
//
package PA07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import PA07.Customer;
import PA07.Commercial;
import PA07.Residential;

public class UserGUI extends JFrame implements ActionListener {
	
	private String fileName;
	private static Customer[] customers;
	
	
	// declare all GUI components below
	private JLabel lblFName;
	private JLabel lblLName;
	private JLabel lblNumber;
	private JLabel lblKWH;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtNumber;
	private JTextField txtKWH;
	
	private JButton btnClose;
	private JButton btnSubmit;
	
	private JTextArea textArea;
	private JScrollPane jp;
	
	private JComboBox cboCustType;
	private JComboBox cboMonth;
	

	
	// constructor
	UserGUI(String fileName, int noOfCustomers){
		customers = new Customer[noOfCustomers];
        this.fileName = fileName;
       
        initComponent();
		doTheLayout();
		
		// add buttons to the action listeners
		btnSubmit.addActionListener(this);
		btnClose.addActionListener(this);
		

		
		// call read data from file
		 try {
				readFromFile(fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		display();
	}

	private void initComponent(){
		// Initialize the GUI components
		// labels and text fields
		 lblFName = new JLabel ("First Name: ");
		 lblLName = new JLabel ("Last Name: ");
		 lblNumber = new JLabel("Customer ID: ");
		 lblKWH = new JLabel("Energy (KWH): ");
		 
		 txtFName = new JTextField(20);
		 txtLName = new JTextField(20);
		 txtNumber = new JTextField(10);
		 txtKWH = new JTextField(10);
		 
		 
	      
	   // combo boxes
		 cboCustType = new JComboBox (new String [] {"Residential", "Commercial"});
		 cboMonth = new JComboBox (new String [] {"1:Jan","2:Feb","3:Mar","4:Apr","5:May","6:Jun","7:Jul","8:Aug","9:Sep","10:Oct","11:Nov","12:Dec"});
	     
	      
	   // define text area and add it to scroll pane   
	   textArea = new JTextArea("Energy Bill: ", 10, 52);
	   textArea.setEditable(false);
	   
	   jp=new JScrollPane(textArea);
	   		      
	      // buttons
	   btnClose = new JButton("Close");
	   btnSubmit = new JButton("Submit");
	}

   private void doTheLayout(){
		// Organize the components into GUI window
	   JPanel top = new JPanel();
	   JPanel center = new JPanel();
	   JPanel centerTop = new JPanel();
	   JPanel centerBottom = new JPanel();
	   JPanel bottom = new JPanel();
	   
	      // add components to the top panel
	   top.add(lblFName);
	   top.add(txtFName);
	   top.add(lblLName);
	   top.add(txtLName);
	   
	   center.setLayout(new BorderLayout());

	      // add components to the centerTop panel
	   centerTop.add(lblNumber);
	   centerTop.add(txtNumber);
	   centerTop.add(cboCustType);
	   centerTop.add(lblKWH);
	   centerTop.add(txtKWH);
	   centerTop.add(cboMonth);
	   
	      
	     // add components to the centerBottom panel
	   centerBottom.add(btnSubmit);
	   centerBottom.add(btnClose);
	   		    
	      // add panels centerTop and centerBottom to the center panel
	   center.add(centerTop, BorderLayout.CENTER);
	   center.add(centerBottom, BorderLayout.SOUTH);
	   
	      
	      // add scroll pane to the bottom panel
	   bottom.add(jp);
	   
	      //add the panels to the GUI content pane
	   this.add(top, "North");
	   this.add(center, "Center");
	   this.add(bottom, "South");
	   
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//call appropriate methods as required based on user actions
		// use if statement to call proper methods to process events
        if (event.getSource() == btnSubmit)
        	btnSubmitClicked();
		else
			try {
				btnCloseClicked();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
		
	}

	private void btnSubmitClicked(){
		// code to be executed once the submit button is clicked
		//add customer object to the customers[] array
		//display the customer objects followed by sum and average
		String FName = "";
		String LName = "";
		int custNumber = 0;
		int energy = 0;
		int custType = 0;
		int billMonth = 0;
		
		try {
			FName = txtFName.getText().trim();
			if (FName.length() == 0)
				throw new Exception();
		}catch (Exception ex){
	    	  JOptionPane.showMessageDialog(txtFName, "Invalid Input");
	    	  txtFName.setText("");
	    	  return;
	    }
		
		try {
			LName = txtLName.getText().trim();
			if (LName.length() == 0)
				throw new Exception();
		}catch (Exception ex){
	    	  JOptionPane.showMessageDialog(txtLName, "Invalid Input");
	    	  txtLName.setText("");
	    	  return;
	    }
		
		try {
			if (txtNumber.getText().trim().length() != 8)
				throw new Exception();
			else
				custNumber = Integer.parseInt(txtNumber.getText().trim());
		}catch (Exception ex){
	    	  JOptionPane.showMessageDialog(txtNumber, "Invalid Input");
	    	  txtNumber.setText("");
	    	  return;
	      }
		
		try {
			energy = Integer.parseInt(txtKWH.getText().trim());
		}catch (Exception ex){
	    	  JOptionPane.showMessageDialog(txtKWH, "Invalid Input");
	    	  txtKWH.setText("");
	    	  return;
	      }
		
		if (cboCustType.getSelectedItem()=="" || cboMonth.getSelectedItem()==""){
			JOptionPane.showMessageDialog(null, "Invalid Selection! \nPlease select the customer type and the bill month!");
			return;
		}
		
		if (cboCustType.getSelectedItem().toString()=="Residential")
	    	 custType=0;
	     else
	    	 custType=1;
	     switch (cboMonth.getSelectedItem().toString()){
			case "Jan":
				billMonth = 1;
				break;
			case "Feb":
				billMonth = 2;
				break;
			case "Mar":
				billMonth = 3;
				break;
			case "Apr":
				billMonth = 4;
				break;
			case "May":
				billMonth = 5;
				break;
			case "Jun":
				billMonth = 6;
				break;
			case "Jul":
				billMonth = 7;
				break;
			case "Aug":
				billMonth = 8;
				break;
			case "Sep":
				billMonth = 9;
				break;
			case "Oct":
				billMonth = 10;
				break;
			case "Nov":
				billMonth = 11;
				break;
			case "Dec":
				billMonth = 12;
				break;
	      }
	      addCustomer(custNumber, FName, LName.trim(),
	    		  custType, energy, billMonth);
		display();
	}
	
	public static double getAvg(){
		// finds the average of the customers bills
		double sum=getSum();
		double avg=sum/Customer.getNumberOfCustomers();
		return avg;
	}
	
	private void display(){
		
		String message = "Electric Bill: \n" 
		+ "Customer ID\t" 
				+ "First Name\t"
		+ "Last Name\t" 
				+ "Customer Type\t" 
		+ "Usage\t" 
				+ "Bill Month\t" 
		+ "Bill\t";
		for (int i = 0; i < Customer.getNumberOfCustomers(); i++)
		   message+="\n" + customers[i].toString();
		
		message+= "\nAverage Bill Values: " + String.format("%.2f", getAvg()) 
		+ "\tTotal Bill Values: " + String.format("%.2f", getSum());
		
		// display message to the text area
		textArea.setText(message);
		
	}
	
	public static double getSum(){
		// finds the sum of the customers bills
		double sum=0.0;
		//ElectricBill temp;
		for(int i=0; i<Customer.getNumberOfCustomers(); i++){
			//temp=customers[i].getBill();
			sum+=customers[i].getBill().getBillAmount();
		}
		return sum;
	}

	private void btnCloseClicked() throws FileNotFoundException{
		// code to be executed once the close button is clicked
		//write sorted output to file
		selectionSort();
		writeToFile();
		
		// It must show a goodbye message and terminate the program
		JOptionPane.showMessageDialog(null, "Good Bye!");
		System.exit(0);

	}
	
	private void selectionSort() {
		
		 for (int i = 0; i < Customer.getNumberOfCustomers() -1; i++) {
		      // Find the minimum in the customers[i..customers.length-1]
		      Customer currentMin = customers[i];
		      int currentMinIndex = i;
	
		      for (int j = i + 1; j < Customer.getNumberOfCustomers(); j++) {
		        if (currentMin.compareTo(customers[j]) > 0) {
		          currentMin = customers[j];
		          currentMinIndex = j;
		        }
		      }
	
		      // Swap customers[i] with customers[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        customers[currentMinIndex] = customers[i];
		        customers[i] = currentMin;
		      }
		    }
	}
	
	private void writeToFile() throws FileNotFoundException {
		File file = new File("customers.txt");

	    // Create a file
	    PrintWriter output = new PrintWriter(file);
		

		for (int i =0; i < Customer.getNumberOfCustomers(); i++)
			output.println(customers[i].toString());

	    // Close the file
	    output.close();
	}



	private void readFromFile(String filename) throws FileNotFoundException {
		
		// Create a File instance
	    java.io.File file = new java.io.File(fileName);

	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);

	    // Read data from a file
	    while (input.hasNext()) {
	      String line = input.nextLine();
	      String[] customer = line.split(",");
	      int custType = 0;
	      int billMonth = 0;
	      if (customer[3].trim()=="Residential")
	    	  custType=0;
	      else
	    	  custType=1;
	      switch (customer[5].trim()){
			case "Jan":
				billMonth = 1;
				break;
			case "Feb":
				billMonth = 2;
				break;
			case "Mar":
				billMonth = 3;
				break;
			case "Apr":
				billMonth = 4;
				break;
			case "May":
				billMonth = 5;
				break;
			case "Jun":
				billMonth = 6;
				break;
			case "Jul":
				billMonth = 7;
				break;
			case "Aug":
				billMonth = 8;
				break;
			case "Sep":
				billMonth = 9;
				break;
			case "Oct":
				billMonth = 10;
				break;
			case "Nov":
				billMonth = 11;
				break;
			case "Dec":
				billMonth = 12;
				break;
	      }
	      addCustomer(Integer.parseInt(customer[0].trim()), customer[1].trim(), customer[2].trim(),
	    		  custType, Integer.parseInt(customer[4].trim()), billMonth);	
	    }

	    // Close the file
	    input.close();
	 }
	
	public static void addCustomer(int custNumber, String fName, String lName, int custType, int noOfKWH,int billMonth){
		// add a new customer object to the customers array
		// you must double check the array size before adding a new customer to the array
		if(Customer.getNumberOfCustomers()<customers.length){
			if(custType==0) 
				customers[Customer.getNumberOfCustomers()]= new Customer(custNumber, fName, lName, custType, new Residential(noOfKWH, billMonth)); 
			else
				customers[Customer.getNumberOfCustomers()]= new Customer(custNumber, fName, lName, custType, new Commercial(noOfKWH, billMonth));
		} else 
			JOptionPane.showMessageDialog(null, "The Array is Full");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//declare variables
		int numberOfcustomers = 0;
		
		// inputs
		numberOfcustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Customers:"));

		UserGUI frame = new UserGUI("customers.txt", numberOfcustomers);
		frame.setTitle("User Electric Bill Application");
	    frame.pack();
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

	}

}

