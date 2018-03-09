import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA04 										  *
//* 																  *
//* Methods					  				  						  *
//* 																  *
//* Date Created: 3.08.2018					    				      *
//* Saved in: LongDoanPA0401.java  									  *
//* 																  *
//*********************************************************************
//
public class LongDoanPA0401 {

	static final double RATE_100=1.99;
	static final double RATE_1=9.99;
	static final double RATE_10=99.99;
	static String type;
	public static void main(String[] args) {
		
		int storage =-1, months = 0;
		boolean isStudent = false;
		String output="";
		
		//Input
		try {
			storage = Integer.parseInt(JOptionPane.showInputDialog(null, "How much storage do you require(Enter 0:100GB, 1:1TB, 2:100TB): "));
    		if(storage != 0 && storage != 1 && storage != 2 )
    			throw new Exception(); //control goes to catch clause
    		}
    		catch(Exception ex) {
    			JOptionPane.showMessageDialog(null, 
    					"Please enter 0 for 100GB, 1 for 1TB, 2 for 100TB",
    					"ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}
		
		try {
			months = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of months: "));
			if(months<0){
				throw new Exception(); //control goes to catch clause
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid Value."
					+ "\nEnter a postive number. \nEx:2");
			System.exit(0);
		}
		
		switch (JOptionPane.showConfirmDialog(null, "Are you are a student: ")){
		case JOptionPane.YES_OPTION:
			isStudent = true;
			break;
		case JOptionPane.NO_OPTION:
			isStudent = false;
			break;
		case -1:
		case 2:
			JOptionPane.showMessageDialog(null, 
					"Please choose YES or NO.",
					"ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			break;
		}
		
		// calculation and output
		if (isStudent){
			output+="Your storage charges("
					+type+") for "
					+months+" months is $" 
					+ String.format("%.2f", storageCharges(storage, months, isStudent));
		} else {
			output+="Your storage charges("
					+type+") for "
					+months+" months is $" 
					+ String.format("%.2f", storageCharges(storage, months));
		}
		
		displayBill(output, "STORAGE CHARGE BILL");
	}
	
	//regular users
	public static double storageCharges(int storage, int month){
		double output = 0;
		switch (storage){
		case 0:
			type="100GB";
			break;
		case 1:
			type="1TB";
			break;
		case 2:
			type="10TB";
			break;
		}
		if (storage == 0 ){
			output = month * RATE_100;
		} else if (storage == 1){
			output=month*RATE_1;
		} else if (storage == 2){
			output=month*RATE_10;
		}
		return output;
	}
	public static double storageCharges(int storage, int month, boolean stu){
		double output = 0;
		if (stu){
			output = LongDoanPA0401.storageCharges(storage,month)*0.9;
		} else {
			output = LongDoanPA0401.storageCharges(storage,month);
		}
		return output;
		
	}
	public static void displayBill(String message, String title) {
		JOptionPane.showMessageDialog(null, new JTextArea(message), title,JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
