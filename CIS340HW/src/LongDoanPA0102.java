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
		String output="";
		//Inputs
		accBal = Double.parseDouble(JOptionPane.showInputDialog("Current Account Balance: "));
		tranType = Integer.parseInt(JOptionPane.showInputDialog("Choose a transaction type (0: Deposit, 1: Withdraw): "));

		//If Withdraw
		if (tranType == 1) {
			amount = Double.parseDouble(JOptionPane.showInputDialog("Withdraw Amount: "));
			finalBal = accBal - amount;
			output=String.format("Balance before withdraw: $%.2f\nFinal Balance: $%.2f", accBal, finalBal);
		} 
		//If Deposit
		else {
			amount = Double.parseDouble(JOptionPane.showInputDialog("Deposit Amount: "));
			finalBal = accBal + amount;
			output=String.format("Balance before deposit: $%.2f\nFinal Balance: $%.2f", accBal, finalBal);
		
		}
		//Display Output
		JOptionPane.showMessageDialog(null, output);
	}

}
