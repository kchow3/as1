package es.softwareprocess.as1;

import java.util.ArrayList;

public class CounterController implements CounterControllerInterface {

	private CounterList counterList;
	
	public CounterController() {
		counterList = new CounterList();
	}

	public void addCounter(Counter aCounter) {
		ArrayList<Counter> list = counterList.getCounterList();
		list.add(aCounter);
	}

}
