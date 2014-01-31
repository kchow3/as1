package cs.ualberta.ca.as1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;

/*
 * CounterController class for creating a controller
 * interface between the accessing the counters and other
 * classes that need to use the counters. This class
 * implements the CounterControllerInterface. This one of
 * the most important classes for this application since
 * it provides a lot of methods such as creating, incrementing,
 * reseting, renaming, sorting and deleting counters and also
 * loads up the statistics for the counters.
 * The design of this class is to create an object such that outside
 * classes can interact with the counters without having direct
 * access to the actual counters, so this class is a interface between
 * the counter list, counters and the class wanting to 
 * access the counters.
 */
public class CounterController implements CounterControllerInterface
{
	//attribute of each controller is a counter list
	private CounterList counterList;

	//construct a controller and pass in a counter list
	public CounterController(CounterList aCounterList) 
	{
		counterList = aCounterList;
	}

	//method to add a counter to the counter list
	public void addCounter(Counter aCounter) 
	{
		ArrayList<Counter> list = counterList.getCounterList();
		list.add(aCounter);
	}

	//method to delete a counter from the counter list
	public void deleteCounter(Counter aCounter)
	{
		ArrayList<Counter> list = counterList.getCounterList();
		list.remove(aCounter);
	}

	//method to rename a selected counter to the passed in name
	public void renameCounter(Counter aCounter, String name) 
	{
		aCounter.setName(name);
	}

	//method to increment a counter
	public void incrementCount(Counter aCounter)
	{
		aCounter.increaseCount();

	}

	//method to reset a counter
	public void resetCount(Counter aCounter)
	{
		//sets count to 0 and clears time arraylist
		aCounter.setCount(0);
		aCounter.clearTime();
	}
	
	/*
	 * method to save the counters through serialization,
	 * this method will write to file.sav the serialized
	 * counter arraylist through a object output stream
	 */
	public void saveCounters(Context aContext)
	{
		try 
		{
			//write to file.sav the serialized counter arraylist
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

	/*
	 * method to load the counters from file.sav that
	 * contains the serialized counter arraylist object
	 * through a object input stream
	 */
	public ArrayList<Counter> loadCounters(Context aContext) 
	{
		try
		{
			//read from file.sav the serialized counter arraylist
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
	
	/*
	 * method to load the stats to be sent to the 
	 * stats activity page, an arraylist of string
	 * is created when calling the counter's stats
	 * methods and is then sent to the stats activity page
	 * through an intent created on the main activity
	 */
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
	
	//method to sort counters using a custom comparator to sort in descending order
	public void sortCounters()
	{
		//custom comparator
		Collections.sort((counterList.getCounterList()), new Comparator<Counter>() {
			@Override
			public int compare(Counter counter1, Counter counter2) {
				return counter2.getCount() - counter1.getCount();
			}
		});
	}
	
}
