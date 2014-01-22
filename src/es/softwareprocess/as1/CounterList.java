package es.softwareprocess.as1;

import java.util.ArrayList;

public class CounterList{
	
	public static ArrayList<Counter> counterList;

	public CounterList() {
		super();
		counterList = new ArrayList<Counter>();
	}

	public static ArrayList<Counter> getCounterList() {
		return counterList;
	}

	public static void setCounterList(ArrayList<Counter> counterList) {
		CounterList.counterList = counterList;
	}
	
	public static int size()
	{
		return counterList.size();
	}
	
	public Counter get(int i) {
		return counterList.get(i);
	}

}
