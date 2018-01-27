//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA01 										  *
//* 																  *
//* Bank Account Transaction   				  						  *
//* 																  *
//* Date Created: 01.25.2018					    			      *
//* Saved in: LongDoanPA0102.java  									  *
//* 																  *
//*********************************************************************
//

import javax.swing.JOptionPane;

public class LongDoanPA0102 {

	public static void main(String[] args) {

		//Declare variables
		int tranType=0;
		double accBal=0, amount=0, finalBal=0;
		int stop = JOptionPane.YES_OPTION;
		String output="";
		
		//Input account balance
		while (stop == JOptionPane.YES_OPTION) {
			accBal = Double.parseDouble(JOptionPane.showInputDialog("Current Account Balance: "));
			//Check current balance below 500
			if (accBal<500) {
				stop = JOptionPane.showConfirmDialog(null, "ERROR: Current Account Balance is below 500."
						+ "\nWould you like to enter agian?");
				if (stop != JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "exit program");
					System.exit(0);
				}
			} else {
				stop = JOptionPane.NO_OPTION;
			}
		}
		stop = JOptionPane.YES_OPTION;
		
		//Input balance type
		while (stop == JOptionPane.YES_OPTION) {
			tranType = Integer.parseInt(JOptionPane.showInputDialog("Choose a transaction type"
					+ " (0: Deposit, 1: Withdraw): "));
			if ((tranType != 1) && (tranType !=0)) {
				stop = JOptionPane.showConfirmDialog(null, "Invalid Input. Would you like to enter agian?");
				if (stop != JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "exit program");
					System.exit(0);
				}
			} else {
				stop = JOptionPane.NO_OPTION;
			}
		}
		stop = JOptionPane.YES_OPTION;
		

		//If Withdraw
		if (tranType == 1) {
			while (stop == JOptionPane.YES_OPTION) {
				amount = Double.parseDouble(JOptionPane.showInputDialog("Withdraw Amount: "));
				//Check legal withdraw
				if (amount>accBal) {
					stop = JOptionPane.showConfirmDialog(null, "ERROR: Withdraw amount is more than current "
							+ "balance.\nWould you like to enter agian?");
					if (stop != JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "exit program");
						System.exit(0);
					}
				} else {
					stop = JOptionPane.NO_OPTION;
				}
			}
			stop = JOptionPane.YES_OPTION;
			
			//Calculation
			finalBal = accBal - amount;
			output=String.format("Balance before withdraw: $%.2f\nFinal Balance: $%.2f", accBal, finalBal);
		} 
		//If Deposit
		else if (tranType == 0) {
			while (stop == JOptionPane.YES_OPTION) {
				amount = Double.parseDouble(JOptionPane.showInputDialog("Deposit Amount: "));
				//Check legal deposit
				if (amount<50) {
					stop = JOptionPane.showConfirmDialog(null, "ERROR: Minimum deposit amount is not met. "
							+ "\nWould you like to enter agian?");
					if (stop != JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "exit program");
						System.exit(0);
					}
				} else {
					stop = JOptionPane.NO_OPTION;
				}
			}
			stop = JOptionPane.YES_OPTION;
						
			
			//Calculation
			finalBal = accBal + amount;
			output=String.format("Balance before deposit: $%.2f\nFinal Balance: $%.2f", accBal, finalBal);
		
		}
		//Display Output
		JOptionPane.showMessageDialog(null, output);
	}

}
