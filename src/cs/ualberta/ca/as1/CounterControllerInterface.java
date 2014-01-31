package cs.ualberta.ca.as1;

import java.util.ArrayList;

import android.content.Context;

/*
 * CounterControllerInterface interface that the counter
 * controller implements. Main responsiblity for the interface
 * is to provide the methods that the controller can use to
 * manipulate the counters.
 * The design of this interface is so that in the future
 * if there is another controller it can have the ability
 * to implement a counter controller interface.
 */
public interface CounterControllerInterface 
{
	public void addCounter(Counter aCounter);
	
	public void deleteCounter(Counter aCounter);
	
	public void renameCounter(Counter aCounter, String name);
	
	public void incrementCount(Counter aCounter);
	
	public void resetCount(Counter aCounter);
	
	public void sortCounters();
	
	public ArrayList<Counter> loadCounters(Context aContext);
	
	public void saveCounters(Context aContext);
	
	public ArrayList<String> loadStats();
}
