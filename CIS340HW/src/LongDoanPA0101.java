//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA01 										  *
//* 																  *
//* Program to Calculate Library Book Fine  						  *
//* 																  *
//* Date Created: 01.25.2018					    			      *
//* Saved in: LongDoanPA0101.java  									  *
//* 																  *
//*********************************************************************
//
import javax.swing.*;
public class LongDoanPA0101 {

	public static void main(String[] args) {
		//Declare Variables
		int actualDay, actualMonth, expectedDay , expectedMonth , dayLate;
		actualDay=actualMonth=expectedDay=expectedMonth=dayLate=0;
		double fine=0;
		String output="";
		//Inputs
		actualDay = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return day"));
		actualMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return month"));
		expectedDay = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return day"));
		expectedMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return month"));
		
		//Calculations
		if (actualMonth < expectedMonth){
			fine=0;
			dayLate=0;
		} else if (actualMonth == expectedMonth){
			if (actualDay <= expectedDay){
				fine=0;
				dayLate=0;
			}else{
			dayLate=actualDay-expectedDay;
			fine=.15*dayLate;
			}
		}else if (actualMonth > expectedMonth){
			//Adjusting for remainder months in the year
			switch (expectedMonth){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				for (int i=expectedMonth+1; i<expectedMonth; i++){
					switch (i){
					case 4:
					case 6:
					case 9:
					case 11:
						dayLate+=30;
						break;
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						dayLate+=31;
						break;
					case 2:
						dayLate+=28;
						break;
					}
				}
				dayLate+=actualDay;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				for (int i=expectedMonth+1; i<expectedMonth; i++){
					switch (i){
					case 4:
					case 6:
					case 9:
					case 11:
						dayLate+=30;
						break;
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						dayLate+=31;
						break;
					case 2:
						dayLate+=28;
						break;
					}
				}
				dayLate+=actualDay;
				break;
			case 2: dayLate+=28-expectedDay;
				for (int i=expectedMonth+1; i<expectedMonth; i++){
					switch (i){
					case 4:
					case 6:
					case 9:
					case 11:
						dayLate+=30;
						break;
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						dayLate+=31;
						break;
					}
				}
				dayLate+=actualDay;
				break;
			}
			fine=500*(actualMonth-expectedMonth);
		}
		//Display output
		output = String.format("Number of days late: %d\nFine Amount: $%.2f", dayLate, fine);
		JOptionPane.showMessageDialog(null, output);
	}


}
