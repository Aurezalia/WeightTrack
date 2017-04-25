package mainPackage;

import java.util.Date;
import java.sql.Timestamp;
import java.time.Instant;

public class Record implements Comparable<Record> {
	int year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour;
	double userHeight, userWeight, userGoal;
	Timestamp timestamp;
	/*
	 * Timestamp timestamp2 = new Timestamp(time);
	 * System.out.println(timestamp2);
	 */

	public Record(Timestamp timestamp, double userHeight, double userWeight, double userGoal) {
		this.timestamp = timestamp;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userGoal = userGoal;
	}

	public Timestamp getTime() {
		return timestamp;
	}

	public String toString(){
		return timestamp + "";	
	}
	
	@Override
	//uses the Comparable interface to set up the logic to sort the Arraylist
	public int compareTo(Record o) {
		//return this.timestamp.compareTo(o.timestamp);
		//System.out.println("Instant milli: " + getTime().toInstant().toEpochMilli());

        if (this.timestamp.toInstant().toEpochMilli() == ((Record) o).timestamp.toInstant().toEpochMilli())
            return 0;
        else if ((this.timestamp.toInstant().toEpochMilli()) < ((Record) o).timestamp.toInstant().toEpochMilli())
            return 1;
        else
            return -1;
	}

	
	
}
