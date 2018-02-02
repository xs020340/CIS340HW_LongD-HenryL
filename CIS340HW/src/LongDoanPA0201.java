//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA02 										  *
//* 																  *
//* Rewrite of Calculate Library Book Fine  						  *
//* 																  *
//* Date Created: 02.01.2018					    			      *
//* Saved in: LongDoanPA0201.java  									  *
//* 																  *
//*********************************************************************
//
import javax.swing.*;
public class LongDoanPA0201 {

	public static void main(String[] args) {
		//Declare Variables
		int actualDay, actualMonth, expectedDay , expectedMonth , dayLate;
		actualDay=actualMonth=expectedDay=expectedMonth=dayLate=0;
		double fine=0;
		String output="";
		int stop = JOptionPane.YES_OPTION;
		int dayFeb;
		//initialize dayFeb
		if (JOptionPane.showConfirmDialog(null, "Is this year a leap year or not? \n(Default: Not leap year; 28 days in February.)")==JOptionPane.YES_OPTION){
			dayFeb=29;
		} else {
			dayFeb=28;
		}
					
		
		//input actual month
		while (stop==JOptionPane.YES_OPTION){
			try{
				actualMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return month"));
				if (actualMonth<0 || actualMonth>12){
					throw new Exception(); //invalid month; go to catch
				}
				break;
			} catch (Exception ex){
				stop = JOptionPane.showConfirmDialog(null, "Invalid Input, would you like to enter agian?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		//input actual day of the month
		while (stop==JOptionPane.YES_OPTION){
			try{
				actualDay = Integer.parseInt(JOptionPane.showInputDialog("Enter actual return day"));
				//validation
				switch (actualMonth){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
					if (actualDay<0 || actualDay>31){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (actualDay<0 || actualDay>30){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				case 2: 
					if (actualDay<0 || actualDay>dayFeb){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				}
				break;
			} catch (Exception ex){
				stop = JOptionPane.showConfirmDialog(null, "Invalid Input, would you like to enter agian?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		//input expected month
		while (stop==JOptionPane.YES_OPTION){
			try{
				expectedMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return month"));
				if (expectedMonth<0 || expectedMonth>12){
					throw new Exception(); //invalid month; go to catch
				}
				break;
			} catch (Exception ex){
				stop = JOptionPane.showConfirmDialog(null, "Invalid Input, would you like to enter agian?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		//input expected day of the month
		while (stop==JOptionPane.YES_OPTION){
			try{
				expectedDay = Integer.parseInt(JOptionPane.showInputDialog("Enter expected return day"));
				//validation
				switch (expectedMonth){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
					if (expectedDay<0 || expectedDay>31){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (expectedDay<0 || expectedDay>30){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				case 2: 
					if (expectedDay<0 || expectedDay>dayFeb){
						throw new Exception(); //invalid day; go to catch
					}
					break;
				}
				break;
			} catch (Exception ex){
				stop = JOptionPane.showConfirmDialog(null, "Invalid Input, would you like to enter agian?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		
		
				
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
				dayLate+=31-expectedDay;
				for (int i=expectedMonth+1; i<actualMonth; i++){
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
						dayLate+=dayFeb;
						break;
					}
				}
				dayLate+=actualDay;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				dayLate+=30-expectedDay;
				for (int i=expectedMonth+1; i<actualMonth; i++){
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
						dayLate+=dayFeb;
						break;
					}
				}
				dayLate+=actualDay;
				break;
			case 2: 
				dayLate+=dayFeb-expectedDay;
				for (int i=expectedMonth+1; i<actualMonth; i++){
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
		fine = fine/100; //converting from cents to dollars
		//Display output
		output = String.format("Number of days late: %d\nFine Amount: $%.2f", dayLate, fine);
		JOptionPane.showMessageDialog(null, output);
	}


}
