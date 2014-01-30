package es.softwareprocess.as1;

import java.util.ArrayList;

import android.content.Context;

public interface CounterControllerInterface {

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
