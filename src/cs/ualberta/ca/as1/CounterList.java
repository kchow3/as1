package cs.ualberta.ca.as1;

import java.util.ArrayList;

public class CounterList{
	
	private static ArrayList<Counter> counterList;

	public CounterList() {
		super();
		counterList = new ArrayList<Counter>();
	}

	public ArrayList<Counter> getCounterList() {
		return counterList;
	}

	public void setCounterList(ArrayList<Counter> counterList) {
		CounterList.counterList = counterList;
	}
	
	public int size()
	{
		return counterList.size();
	}
	
	public Counter get(int i) {
		return counterList.get(i);
	}

}
