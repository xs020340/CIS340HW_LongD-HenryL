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
//* Saved in: Residential.java  										  *
//* 																  *
//*********************************************************************
//

public class Residential extends ElectricBill{


	// complete the constructor	
	public Residential(int noOfKWH,int billMonth) { 
		super(noOfKWH, billMonth);
		computeBill();
	}

	@Override
	public void computeBill() {
		double billAmt=0.0;
		if (this.getBillMonth()<=9 && this.getBillMonth()>=6){
			if (this.getNoOfKWH()<=500){
				billAmt=BASE_RESIDENTIAL_CUST+0.04604*this.getNoOfKWH();
			} else if (this.getNoOfKWH()>500){
				billAmt=BASE_RESIDENTIAL_CUST+0.04604*500+.09*(this.getNoOfKWH()-500);
			}
		} else {
			billAmt=BASE_RESIDENTIAL_CUST+0.04604*this.getNoOfKWH();
		}
		this.setBillAmount(billAmt);
	}






}


