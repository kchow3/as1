package es.softwareprocess.as1;

public interface CounterControllerInterface {

	public void addCounter(Counter aCounter);
	
	public void deleteCounter(Counter aCounter);
	
	public void renameCounter(String name, int index);
	
	public void incrementCount(Counter aCounter);
	
	public void resetCount(Counter aCounter);
}
