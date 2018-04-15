package PA07;
//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Henry Liu  									  *
//* 																  *
//* Program Assignment PA07 										  *
//* 																  *
//*  PA07			  				  								  *
//* 																  *
//* Date Created: 04.15.2018					    			      *
//* Saved in: Residential.java  									  *
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
		int billMonth=this.getBillMonth();
		int KWH=this.getNoOfKWH();
		if (billMonth<=9 && billMonth>=6){
			if (KWH<=500){
				billAmt=BASE_RESIDENTIAL_CUST+0.04604*KWH;
			} else if (KWH>500){
				billAmt=BASE_RESIDENTIAL_CUST+0.04604*500+.09*(KWH-500);
			}
		} else {
			billAmt=BASE_RESIDENTIAL_CUST+0.04604*KWH;
		}
		this.setBillAmount(billAmt);
	}






}


