package es.softwareprocess.as1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;

public class CounterController implements CounterControllerInterface {

	private CounterList counterList;

	public CounterController(CounterList aCounterList) {
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

	public void saveCounters() {
		try 
		{
			FileOutputStream fos = openFileOutput("file.sav", Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(counterList.getCounterList());
			oos.flush();
			oos.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}

	}

	public ArrayList<Counter> loadCounters() {
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.sav"));
			Object o = ois.readObject();
			return (ArrayList<Counter>)o;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

}
