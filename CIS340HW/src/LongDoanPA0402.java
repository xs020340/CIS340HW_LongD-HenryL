
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA04 										  *
//* 																  *
//* Methods			  				  								  *
//* 																  *
//* Date Created: 03.08.2018					    			      *
//* Saved in: LongDoanPA0402.java  									  *
//* 																  *
//*********************************************************************
//
public class LongDoanPA0402 {

	static int num=0;
	static int stop = JOptionPane.YES_OPTION;
	static final double BASE_RES=6.75, BASE_COM=10.75, RATE_RES_WINTER=0.04604, RATE_RES_SUMMER_1=0.04604,
			RATE_RES_SUMMER_2=0.09000, RATE_COM_WINTER=0.03920, RATE_COM_SUMMER=0.06450;
	

	// initialize arrays
	static String [] custInfo;
	static double [] billAmount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output1 = "";
		output1 = "Name\tCustomer Type \tEnergy Used \tMonth \tBill Amount\n";
		// input of numbers of customers
		
		while (stop==JOptionPane.YES_OPTION){
			try {
				num=Integer.parseInt(JOptionPane.showInputDialog("Number of Customers."));
				if (num<0)
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
		
		// initialize 
		
		int custType=0, month=0;
		String custName="",custTypeStr="",monthStr="";
		double energyUsed=0;
		
		custInfo = new String [num];
		billAmount = new double [num];
				
		for (int i=0;i<num;i++){
			// real Input
			while (stop==JOptionPane.YES_OPTION){
				try {
					custType=Integer.parseInt(JOptionPane.showInputDialog("Type of customer (0 for Residential; 1 for Commercial): "));
					if (custType<0)
						System.exit(0);
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
			if (custType==0){
				custTypeStr="Residential";
			} else {
				custTypeStr="Commercial";
			}
			
			while (stop==JOptionPane.YES_OPTION){
				try {
					custName=JOptionPane.showInputDialog("Name of the customer - First Name Last Name: ");
					if (custName=="")
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
					energyUsed=Double.parseDouble(JOptionPane.showInputDialog("Energy usage (kWh decimal value): "));
					if (energyUsed<=0)
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
					month=Integer.parseInt(JOptionPane.showInputDialog("Month for the bill (1 for Jan, 2 for Feb, etc): "));
					if (month>12 || month<1)
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
			switch (month)
			{
			case 1:
				monthStr = "Jan";
				break;
			case 2:
				monthStr = "Feb";
				break;
			case 3:
				monthStr = "Mar";
				break;
			case 4:
				monthStr = "Apr";
				break;
			case 5:
				monthStr = "May";
				break;
			case 6:
				monthStr = "Jun";
				break;
			case 7:
				monthStr = "Jul";
				break;
			case 8:
				monthStr = "Aug";
				break;
			case 9:
				monthStr = "Sep";
				break;
			case 10:
				monthStr = "Oct";
				break;
			case 11:
				monthStr = "Nov";
				break;
			case 12:
				monthStr = "Dec";
				break;
			}
			custInfo[i] = custName +"\t" +custTypeStr  +"\t" + energyUsed  +"\t" + monthStr + "\t $";
			
			// calculation of the bill
			if (custType  == 0){
				billAmount[i]=resElecBill(month, energyUsed);
			} else if (custType == 1){
				billAmount[i]=comElecBill(month, energyUsed);
			}
			
			//output1
			 output1 += custInfo[i]+String.format("%.2f", billAmount[i])+"\n";
		}
		
		//display output
		output1 += "\nHighest Cost Customer Bill: $" + String.format("%.2f", highestCalc())+"\n";
		output1 += "Lowest Cost Customer Bill: $" + String.format("%.2f", lowestCalc())+"\n";
		displayBill(output1,"ELECTRIC BILL CALCULATOR");
		
	}
		//End Main
	
	public static double resElecBill(int month, double energyUsed){
		double billAmt=0.0;
		if (month<=9 && month>=6){
			if (energyUsed<=500){
				billAmt=BASE_RES+RATE_RES_SUMMER_1*energyUsed;
			} else if (energyUsed>500){
				billAmt=BASE_RES+RATE_RES_SUMMER_1*500+RATE_RES_SUMMER_2*(energyUsed-500);
			}
		} else {
			billAmt=BASE_RES+RATE_RES_WINTER*energyUsed;
		}
		return billAmt;
	}
	public static double comElecBill(int month, double energyUsed){
		double billAmt=0.0;
		if (month<=9 && month>=6){
			billAmt=BASE_COM+RATE_COM_SUMMER*energyUsed;
		} else {
			billAmt=BASE_COM+RATE_COM_WINTER*energyUsed;
		}
		return billAmt;
	}
	public static double highestCalc(){
		double highestCust=0;
		sortTotalCost();
		highestCust=billAmount[billAmount.length-1];
		return highestCust;
	}
	public static double lowestCalc(){
		double lowestCust=0;
		sortTotalCost();
		lowestCust=billAmount[0];
		return lowestCust;
	}
	public static void sortTotalCost() {
		int i,j;
		for (i = 0; i < billAmount.length - 1; i++) {
			
			int currentMinIndex = i;
			double currentMin = billAmount[i];
			String currentMinInfo=custInfo[i];

			for(j=i+1;j<billAmount.length;j++) {
				if(billAmount[j]<currentMin) {
					currentMin=billAmount[j];
					currentMinInfo=custInfo[j];
					currentMinIndex=j;
				}//end if
			}//end inner for
			
			//swapping variables 
			if(currentMinIndex!=j) {
				billAmount[currentMinIndex]=billAmount[i];
				billAmount[i]=currentMin;
				custInfo[currentMinIndex]=custInfo[i];
				custInfo[i]=currentMinInfo;
			}
		}//end outer for
	}
	
	
	public static void displayBill(String message, String title) {
		JOptionPane.showMessageDialog(null, new JTextArea(message), title,JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
}
