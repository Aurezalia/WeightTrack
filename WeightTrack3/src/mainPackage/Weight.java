package mainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Weight {
	private Double BMIweight, BMIheight, square, BMI, userHeight, userWeight, userGoal;;
	private String userName, password, time;
	private Timestamp ts;
	ArrayList<Record> weightArray = new ArrayList<Record>();;
	Impl main;

	@SuppressWarnings("resource")
	//when a Weight object is created (in the main class), this scans the File and creates objects of everything contained within it
	public Weight(File fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileName).useDelimiter(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//scans the first line to pull the password
		password = scanner.next().trim();

		//scans through the rest of the lines that hold the user records
		//makes Record objects of each line
		while (scanner.hasNext()) {
			time = scanner.next().trim();
			userHeight = Double.parseDouble(scanner.next().trim());
			userWeight = Double.parseDouble(scanner.next().trim());
			userGoal = Double.parseDouble(scanner.next().trim());
			ts = Timestamp.valueOf(time);
			weightArray.add(new Record(ts, userHeight, userWeight, userGoal));
		}
	}

	/*
	 * public void retrieveLines(File filename) throws IOException { Scanner
	 * read = new Scanner(filename); read.useDelimiter(","); String name,
	 * height, goal, password; double weight;
	 * 
	 * password = read.next(); while (read.hasNext()) { height = read.next();
	 * weight = Double.parseDouble(read.next()); weightArray.add(weight); goal =
	 * read.next(); } read.close(); for (int i = 0; i < weightArray.size(); i++)
	 * { System.out.println(weightArray.get(i)); } }
	 */

	//calculates BMI
	public String getBMI() {
		BMIweight = userWeight * 0.45;
		BMIheight = userHeight * 0.025;
		square = Math.pow(BMIheight, 2);
		BMI = BMIweight / square;
		String BMIstring = String.format("%.1f", BMI);
		return BMIstring;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getUserHeight() {
		return userHeight;
	}

	public Timestamp getTimestamp() {
		return ts;
	}

	public String getTimeString() {
		return time;
	}

	//converts the Double height to a string
	public String getHeightString() {
		String heightString = String.format("%.1f", userHeight);
		return heightString;
	}

	public void setUserHeight(Double userHeight) {
		this.userHeight = userHeight;
	}

	public Double getUserWeight() {
		return userWeight;
	}

	//converts the weight double to a string
	public String getWeightString() {
		String weightString = String.format("%.1f", userWeight);
		return weightString;
	}

	public void setUserWeight(Double userWeight) {
		this.userWeight = userWeight;
	}

	public Double getUserGoal() {
		return userGoal;
	}

	public void setUserGoal(Double userGoal) {
		this.userGoal = userGoal;
	}

	//converts goal Double to a string
	public String getGoalString() {
		String goalString = String.format("%.1f", userGoal);
		return goalString;
	}
	
	//calculates how much left to goal and then converts it to a string to be put in GUI
	public String getGoal(Double userWeight) {
		this.userWeight = userWeight;
		Double goalLeft = userWeight - userGoal;
		String goalString = String.format("%.1f", goalLeft);
		return goalString;
	}

}
