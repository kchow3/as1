package es.softwareprocess.as1;
import java.util.*;

public class Counter {
	
	private String name;
	private int count;
	private ArrayList<Date> time;
	
	//Constructor method
	public Counter(String counter_name)
	{
		this.name = counter_name;
		this.count = 0;
		this.time = new ArrayList<Date>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public ArrayList<Date> getDate()
	{
		return time;
	}
	
	public void increase()
	{
		count++;
	}
	
	public void change_name(String new_name)
	{
		this.name = new_name;
	}
	
	public void reset_counter()
	{
		this.count = 0;
		this.time = new ArrayList<Date>();
	}

}
