//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA02											  *
//* 																  *
//* Bitcoin Transaction 	   				  						  *
//* 																  *
//* Date Created: 2.01.2018						    			      *
//* Saved in: LongDoanPA0202.java  									  *
//* 																  *
//*********************************************************************
//

import javax.swing.JOptionPane;

public class LongDoanPA0202 {

	public static void main(String[] args) {
		
		//Declare Variables
		double currentBC = 0,  buy = 0, sell =0, sellAmount, buyAmount, buyingUSD, sellingUSD, totalBuyBit = 0;
		int transType =0;
		String buyingTotal ="", sellingTotal = "";
		
		//Input for Current Bitcoins
		try {
		currentBC = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter number of Bitcoin you own: "));
		if (currentBC < 1)
			throw new Exception (); 	
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Bitcoin value must be over 1. " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//Input for Transaction Type
		try {
			transType = Integer.parseInt((JOptionPane.showInputDialog(null, "Choose a transaction type (0: Buy, 1: Sell): ")));
			if (transType != 1 && transType != 0)
				throw new Exception (); 	
			
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Please Enter 1 0r Zero. " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//BUYING
		if (transType == 0){
		try {
			buy = Double.parseDouble((JOptionPane.showInputDialog(null, "Amount you wish to spend on buying bitcoins: ")));
			if (buy < currentBC)
				throw new Exception ();
			
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "You Do not have sufficient funds in your balance. " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			
		
		}
		//Calculations for Buying Bitcoins
		buyAmount = buy/15000;
		totalBuyBit = buyAmount+currentBC;
		buyingUSD = buy + 15000;
		buyingTotal = "Bitcoins for $" + buy + " :" + buyAmount + 
					  "\nTotal Bitcoins:   " + totalBuyBit + 
					  "\nAmount in USD:   $" + buyingUSD;
		
		//OUTPUT for buying 
		JOptionPane.showMessageDialog(null, buyingTotal);
		}
		
		
		//SELLING
		if (transType == 1){
			try {
				sell = Double.parseDouble((JOptionPane.showInputDialog(null, "Amount you wish to sell Bitcoins for: ")));
				if (sell < 100.00)
					throw new Exception ();
				
			} catch (Exception ex){
				JOptionPane.showMessageDialog(null, "You must deposit over $100.00 " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				
			
			}
			/*Calculations for Buying Bitcoins
			sellAmount = 15000*sell;
			sellingUSD = sell - 15000;
			SellingTotal = sell + " " + "in Bitcoin is " + sellAmount" \nTotal Bitcoins: " +
						  "Total Bitcoins:   " + buyAmount + 
						  "Amount in USD:   $" + buyingUSD;
			
			//OUTPUT for buying 
			JOptionPane.showMessageDialog(null, buyingTotal); */

		}
	}
}
		
