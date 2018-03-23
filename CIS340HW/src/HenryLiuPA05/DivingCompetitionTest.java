//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Henry Liu & Long Doan  						  *
//* 																  *
//* Program Assignment PA0501 										  *
//* 																  *
//* Objects and class methods			  				  			  *
//* 																  *
//* Date Created: 03.22.2018					    			      *
//* Saved in: HenryLiuPA0501.java  									  *
//* 																  *
//*********************************************************************
//
package HenryLiuPA05;
import java.io.*;
import javax.swing.JOptionPane;

public class DivingCompetitionTest {
	
	static int num=0;
	static int stop = JOptionPane.YES_OPTION;
	static DivingCompetitor [] competitorsArr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input
		String firstName="";
		String lastName="";
		while (stop==JOptionPane.YES_OPTION){
			try {
				num=Integer.parseInt(JOptionPane.showInputDialog("Number of Divers."));
				if (num<0)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Values must be above zero and integer.");
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}//end num input
		while (stop==JOptionPane.YES_OPTION){
			try {
				DivingCompetitor.setDiffLevel(Integer.parseInt(JOptionPane.showInputDialog("Set the difficulty level (1-5).")));
				if (DivingCompetitor.getDiffLevel()<1 && DivingCompetitor.getDiffLevel()>5)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Values must be between 1 and 5.");
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}//end difflevel input
		
		//initialize array
		competitorsArr = new DivingCompetitor[num];
		
		for (int i=0;i<num;i++){
			while (stop==JOptionPane.YES_OPTION){
				try {
					firstName=JOptionPane.showInputDialog("Please enter the first name of No."+(i+1)+" diver.");
					lastName=JOptionPane.showInputDialog("Please enter the last name of No."+(i+1)+" diver.");
					if (firstName=="" && lastName=="")
						throw new Exception();
					break;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Names cannot be empty");
					stop = JOptionPane.showConfirmDialog(null, "Re-enter?");
					if (stop!=JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Exit Program");
						System.exit(0);
					}
					continue;
				}
			}
			competitorsArr[i] = new DivingCompetitor(firstName,lastName);
			
			competitorsArr[i].generatePoints();
			competitorsArr[i].getAvg();
			competitorsArr[i].getFinal();
			
		}//end for
		
		sortCompetitorArray();
		try {
			writeToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayScore();

	}//end of main
	
	public static void sortCompetitorArray(){
		DivingCompetitor temp;
		for(int i=0; i<competitorsArr.length; i++){
			for(int j=i; j<competitorsArr.length; j++){
				if (competitorsArr[j].getFinalScore()>competitorsArr[i].getFinalScore()) {
					temp=competitorsArr[i];
					competitorsArr[i]=competitorsArr[j];
					competitorsArr[j]=temp;
				}
			}
		}
	}
	
	public static void displayScore() {
		String output="";
		for (int i=0; i<competitorsArr.length; i++) {
			output+=competitorsArr[i].toString()+"\n";
		}
		JOptionPane.showMessageDialog(null, output, "DIVING COMPETITION SCORE", JOptionPane.INFORMATION_MESSAGE);
	} //end displayBill()
	
	public static void writeToFile() throws FileNotFoundException {
		String fileOutput="";
		File myfile=new File("Scores.txt");
		
		PrintWriter outputFile=new PrintWriter(myfile);
		
		for (int i=0; i<competitorsArr.length; i++) {
			fileOutput+=competitorsArr[i].toString()+"\n";
		}
		
		outputFile.print(fileOutput);
		outputFile.close();
		
	}
}

