package es.softwareprocess.as1;
import java.util.*;

public class Counter {
	
	private String name;
	private int count;
	private ArrayList<Date> time;
	
	//Constructor method
	public Counter()
	{
		this.name = "Counter Name";
		this.count = 0;
		this.time = new ArrayList<Date>();
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Date> getTime() {
		return time;
	}

	public void setTime(ArrayList<Date> time) {
		this.time = time;
	}
	

}
