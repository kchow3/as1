package cs.ualberta.ca.as1;

import java.util.ArrayList;

/*
 * CounterList class is used to create a arraylist of 
 * counters so that the application has a collection
 * of counters that uses methods in the controller to
 * manipulate the counters in the list.
 * The design of this class is so that the application
 * has a static counterlist that is the same when
 * accessed.
 */
public class CounterList
{
	//static variable of arraylist of couters
	private static ArrayList<Counter> counterList;

	//counterlist constructor that creates new arraylist
	public CounterList() 
	{
		super();
		counterList = new ArrayList<Counter>();
	}

	//Getters and Setters
	public ArrayList<Counter> getCounterList() 
	{
		return counterList;
	}

	public void setCounterList(ArrayList<Counter> counterList) 
	{
		CounterList.counterList = counterList;
	}
	
	//arraylist size method
	public int size()
	{
		return counterList.size();
	}
	
	//arraylist get method
	public Counter get(int i) 
	{
		return counterList.get(i);
	}

}
