package es.softwareprocess.as1;

public interface CounterControllerInterface {

	public void addCounter(Counter aCounter);
	
	public void deleteCounter(Counter aCounter);
	
	public void renameCounter(Counter aCounter, String name);
	
	public void incrementCount(Counter aCounter);
	
	public void resetCount(Counter aCounter);
	
	public void loadCounters();
	
	public void saveCounters();
}
