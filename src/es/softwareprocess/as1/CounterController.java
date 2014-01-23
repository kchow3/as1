package es.softwareprocess.as1;

import java.util.ArrayList;

public class CounterController implements CounterControllerInterface {

	private CounterList counterList;
	
	public CounterController(CounterList aCounterList) 
	{
		counterList = aCounterList;
	}

	public void addCounter(Counter aCounter) {
		ArrayList<Counter> list = counterList.getCounterList();
		list.add(aCounter);
	}
	
	public void deleteCounter(Counter aCounter) {
		ArrayList<Counter> list = counterList.getCounterList();
		list.remove(aCounter);
	}
	
	public void renameCounter(Counter aCounter, String name) {
		aCounter.setName(name);
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
