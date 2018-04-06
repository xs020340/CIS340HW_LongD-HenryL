package PA06;
//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA06 										  *
//* 																  *
//*  PA06			  				  								  *
//* 																  *
//* Date Created: 04.05.2018					    			      *
//* Saved in: ElectricBill.java  										  *
//* 																  *
//*********************************************************************
//

public abstract class ElectricBill implements BaseCharge{

	
	private int noOfKWH;
	private int billMonth;
	private double billAmount;

	public ElectricBill() {
		this.noOfKWH = 0;
		this.billMonth = 0;
	}

	public ElectricBill(int noOfKWH,int billMonth) {
		this.noOfKWH = noOfKWH;
		this.billMonth = billMonth;
	}



	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}



	public int getNoOfKWH() {
		return noOfKWH;
	}



	public int getBillMonth() {
		return billMonth;
	}



	public double getBillAmount() {
		return billAmount;
	}



	@Override
	public String toString() {
		String monthStr="";
		switch (billMonth)
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
		return noOfKWH + "\t" + monthStr + "\t" + String.format("%.2f", billAmount);
	}
	
	
	
	
	// add the toString method

		 
}
