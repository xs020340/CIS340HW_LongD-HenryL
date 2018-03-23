package HenryLiuPA05;

public class DivingCompetitor {
	private String firstName;
	private String lastName;
	private int[] points = new int[7];
	private static int diffLevel;
	private double avgPoints;
	private double finalScore;
	
	
	public int[] getPoints() {
		return points;
	}

	public void setPoints(int[] points) {
		this.points = points;
	}
	
	public DivingCompetitor(){
		super();
		this.firstName = null;
		this.lastName = null;
	}

	public DivingCompetitor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static int getDiffLevel() {
		return diffLevel;
	}
	public double getAvgPoints() {
		return avgPoints;
	}
	
	public double getFinalScore() {
		return finalScore;
	}

	public void setAvgPoints(double avgPoints) {
		this.avgPoints = avgPoints;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	public static void setDiffLevel(int diffLevel) {
		DivingCompetitor.diffLevel = diffLevel;
	}
	
	
	public void generatePoints(){
		for (int i=0; i<7; i++){
			points[i]=(int)(Math.random()*10);
		}
	}
	
	public void getAvg(){
		int sum=0;
		int max=0;
		int min=10;
		for (int j=0; j<points.length; j++) { 
			sum+=points[j];
			if (points[j]>max) max=points[j];
			if (points[j]<min) min=points[j];
		}
		this.avgPoints=((double)(sum-max-min))/5;
	}
	
	public void getFinal(){
		//We assumed that you multiply difficulty and average point since the instruction didnt say how to compute it.
		finalScore=diffLevel*avgPoints;
	}

	@Override
	public String toString() {
		return "Diver Name: " + firstName +  " " + lastName + "; Final Score: " + String.format("%.2f", finalScore);
	}
	
	

}
