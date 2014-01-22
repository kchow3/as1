package es.softwareprocess.as1;

import java.util.ArrayList;

public class CounterController implements CounterControllerInterface {

	private CounterList counterList;
	
	public CounterController() 
	{
		counterList = new CounterList();
	}

	public void addCounter(Counter aCounter) {
		ArrayList<Counter> list = counterList.getCounterList();
		list.add(aCounter);
	}
	
	public void deleteCounter(Counter aCounter) {
		ArrayList<Counter> list = counterList.getCounterList();
		list.remove(aCounter);
		//TODO if this doesn't work, have to pass in index for the counter
	}
	
	public void renameCounter(String name, int index) {
		ArrayList<Counter> list = counterList.getCounterList();
		Counter oldCounter = list.get(index);
		oldCounter.setName(name);
	}

	public void incrementCount(Counter aCounter) {
		aCounter.increaseCount();
		
	}

	public void resetCount(Counter aCounter) {
		aCounter.setCount(0);
	}
	
	public void saveCounters()
	{
		
	}
	
	public void loadCounters()
	{
		
	}

}
