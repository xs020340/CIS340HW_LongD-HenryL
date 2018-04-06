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
//* Saved in: BaseCharge.java  										  *
//* 																  *
//*********************************************************************
//
public interface BaseCharge {
	
	final static double BASE_RESIDENTIAL_CUST = 6.75;
	final static double BASE_COMMERCIAL_CUST = 10.75;
	
	/** Abstract method computeBill */
	abstract void computeBill(); // computes the customer bill


}
