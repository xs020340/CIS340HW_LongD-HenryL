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
//* Saved in: Commercial.java  										  *
//* 																  *
//*********************************************************************
//

public class Commercial extends ElectricBill{


	// complete the constructor	
	public Commercial(int noOfKWH,int billMonth) { 
		super(noOfKWH, billMonth);
		computeBill();
	}

	@Override
	public void computeBill() {
		double billAmt=0.0;
		if (this.getBillMonth()<=9 && this.getBillMonth()>=6){
			billAmt=BASE_COMMERCIAL_CUST+0.06450*this.getNoOfKWH();
		} else {
			billAmt=BASE_COMMERCIAL_CUST+0.03920*this.getNoOfKWH();
		}
		this.setBillAmount(billAmt);		
	}
	
}