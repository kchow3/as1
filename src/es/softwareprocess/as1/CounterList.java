package es.softwareprocess.as1;

import java.util.ArrayList;

public class CounterList {
	
	private static ArrayList<Counter> counterList;

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

}
