//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Henry Liu  									  *
//* 																  *
//* Program Assignment PA07 										  *
//* 																  *
//*  PA07			  				  								  *
//* 																  *
//* Date Created: 04.15.2018					    			      *
//* Saved in: BaseCharge.java  										  *
//* 																  *
//*********************************************************************
//
package PA07;

public interface BaseCharge {
	
	final static double BASE_RESIDENTIAL_CUST = 6.75;
	final static double BASE_COMMERCIAL_CUST = 10.75;
	
	/** Abstract method computeBill */
	abstract void computeBill(); // computes the customer bill


}
