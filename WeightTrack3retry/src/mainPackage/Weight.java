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
	newLinkedList<Record> weightStack = new LinkedListStack<Record>();
	
	@SuppressWarnings("resource")
	// when a Weight object is created (in the main class), this scans the File
	// and creates objects of everything contained within it
	public Weight(File fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileName).useDelimiter(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		password = scanner.next().trim(); // scans the first line to pull the
											// password
		scanning(scanner); // starts recursive scanning function

	}

	// scans through the rest of the lines that hold the user records
	// makes Record objects of each line
	public void scanning(Scanner inputScanner) {
		if (!inputScanner.hasNext())
			return;

		time = inputScanner.next().trim();
		userHeight = Double.parseDouble(inputScanner.next().trim());
		userWeight = Double.parseDouble(inputScanner.next().trim());
		userGoal = Double.parseDouble(inputScanner.next().trim());
		ts = Timestamp.valueOf(time);
		weightStack.push(new Record(ts, userHeight, userWeight, userGoal));
		scanning(inputScanner);
	}

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
