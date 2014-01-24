package es.softwareprocess.as1;

import java.util.ArrayList;

public interface CounterControllerInterface {

	public void addCounter(Counter aCounter);
	
	public void deleteCounter(Counter aCounter);
	
	public void renameCounter(Counter aCounter, String name);
	
	public void incrementCount(Counter aCounter);
	
	public void resetCount(Counter aCounter);
	
	public ArrayList<Counter> loadCounters();
	
	public void saveCounters();
}
