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
		double currentBC = 0,  transAmt = 0, bitAmt = 0, amountUSD, totalBit = 0;
		int transType =0;
		String output ="", transTypeStr = "", title="";
		final double BIT_PRICE=15000;
		int stop = JOptionPane.YES_OPTION;

		
		//Input for Current Bitcoins
		while (stop==JOptionPane.YES_OPTION){
			try {
				currentBC = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter number of Bitcoin you own: "));
				if (currentBC < 1)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Bitcoin value must be over 1. " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		
		//Input for Transaction Type
		while (stop==JOptionPane.YES_OPTION){
			try {
				transType = Integer.parseInt((JOptionPane.showInputDialog(null, "Choose a transaction type (0: Buy, 1: Sell): ")));
				if (transType != 1 && transType != 0)
					throw new Exception();
				switch (transType) {
					case 0:
						transTypeStr="buying";
						break;
					case 1:
						transTypeStr="selling";
						break;
				}
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Please Enter 1 or 0. " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		
		
		//Transaction
		switch (transType) {
			case 0:
				while (stop==JOptionPane.YES_OPTION){
					try {
						transAmt = Double.parseDouble((JOptionPane.showInputDialog(null, "Amount you wish to spend on "+ transTypeStr +" bitcoins: $")));
						if (transAmt < 100)
							throw new Exception();
						break;
					} catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Minimum buying amount is $100 ! " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
						stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
						if (stop!=JOptionPane.YES_OPTION){
							JOptionPane.showMessageDialog(null, "Exit Program");
							System.exit(0);
						}
						continue;
					}
				}
				//Calculations for Buying Bitcoins
				bitAmt = transAmt/BIT_PRICE;
				totalBit = currentBC+bitAmt;
				break;
			case 1:
				while (stop==JOptionPane.YES_OPTION){
					try {
						transAmt = Double.parseDouble((JOptionPane.showInputDialog(null, "Amount you wish to spend on "+ transTypeStr +" bitcoins: $")));
						if (transAmt > currentBC*BIT_PRICE)
							throw new Exception();
						break;
					} catch (Exception ex){
						JOptionPane.showMessageDialog(null, "Insufficient Bitcoins in your balance! " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
						stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
						if (stop!=JOptionPane.YES_OPTION){
							JOptionPane.showMessageDialog(null, "Exit Program");
							System.exit(0);
						}
						continue;
					}
				}
				//Calculations for Selling Bitcoins
				bitAmt = transAmt/BIT_PRICE;
				totalBit = currentBC-bitAmt;
				break;
		}
		amountUSD = totalBit*BIT_PRICE; //Total amount calculation

						
			//OUTPUT 
			output = String.format("Bitcoins for $%,d:     %.3f "
					+ "\nTotal Bitcoins:               %.3f "
					+ "\nAmount in USD:            $%,d"
					, (int)transAmt, bitAmt, totalBit, (int)amountUSD);
			title = "Result of "+transTypeStr+" Bitcoin:";
			JOptionPane.showMessageDialog(null, output, title, 1);
		
		
	}
}
		
