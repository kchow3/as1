package cs.ualberta.ca.as1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;

public class CounterController implements CounterControllerInterface
{

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
		aCounter.clearTime();
	}
	
	public void saveCounters(Context aContext){
		try 
		{
			FileOutputStream fos =  aContext.openFileOutput("file.sav", Context.MODE_PRIVATE);
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

	public ArrayList<Counter> loadCounters(Context aContext) {
		try
		{
			FileInputStream fis = aContext.openFileInput("file.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			return (ArrayList<Counter>)o;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> loadStats()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for(Counter aCounter : (counterList.getCounterList()))
		{
			if(aCounter.getCount() > 0)
			{
				//add counter name
				list.add((aCounter.getName() + " -- COUNT STATISTICS:"));
				//get count per hour
				list.add("Counts Per Hour:");
				list.addAll(aCounter.countPerHour());
				//get count per day
				list.add("Counts Per Day:");
				list.addAll(aCounter.countPerDay());
				//get count per week
				list.add("Counts Per Week:");
				list.addAll(aCounter.countPerWeek());
				//get count per month
				list.add("Counts Per Month:");
				list.addAll(aCounter.countPerMonth());
			}
			
		}
		return list;
	}
	
	public void sortCounters()
	{
		Collections.sort((counterList.getCounterList()), new Comparator<Counter>() {
			@Override
			public int compare(Counter counter1, Counter counter2) {
				return counter2.getCount() - counter1.getCount();
			}
		});
	}
	
}
