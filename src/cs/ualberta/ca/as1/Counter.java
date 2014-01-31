package cs.ualberta.ca.as1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * Counter Class for the counter objects
 * this object represents the counters and has attributes:
 * name, count and a list of time of each count.
 * This class implements serializable so the counter objects
 * can be saved into a serial form and loaded from.
 * This class is mainly called from the counter controller to
 * manipulate the properties of a counter object. 
 * The design of this class is a counter object that can be stored
 * in the counter list class and accessible through the 
 * countercontroller interface.
 */
public class Counter implements Serializable
{
	//serialversionUID
	private static final long serialVersionUID = 547813201;
	
	//attributes of each instance of counter
	private String name;
	private int count;
	private ArrayList<Calendar> time;
	
	//Constructor method
	public Counter(String name)
	{
		this.name = name;
		this.count = 0;
		this.time = new ArrayList<Calendar>();
	}

	//Getters and Setters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}

	public ArrayList<Calendar> getTime() 
	{
		return time;
	}

	public void setTime(ArrayList<Calendar> time) 
	{
		this.time = time;
	}
	
	/*
	 * the method that increases the counter's count
	 * and adds the current time stamp to the time list
	 * which will be used for loading statistics of the counter
	 */
	public void increaseCount()
	{
		this.count++;
		//get the current time stamp
		Calendar date = Calendar.getInstance();
		this.time.add(date);
	}

	//clear the time after a count reset
	public void clearTime()
	{
		this.time.clear();
	}
	
	/*
	 * this method counts how many counts that happened
	 * in an hour and groups them together to send
	 * off as an ArrayList of strings so that the statistics
	 * activity can list them as a view for the user
	 */
	public ArrayList<String> countPerHour()
	{
		//initialize variables
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i++)
		{
			//count=1 for the first time stamp
			count = 1;
			//get the current calendar object
			Calendar cal1 = time.get(i);
			
			//format for the output as a string
			format = (new SimpleDateFormat("MMM d, HH:mm")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				//get the next calendar object for comparison
				Calendar cal2 = time.get(j);
				//check if during the same hour
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
						cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY))
				{
					//increase the count
					count++;
					//increase index i to skip this calendar object later when exiting this loop
					i++;
				}
			}
			//add the result to the output list that will be sent to statistics page
			list.add(format + " -- " + Integer.toString(count));
		}
		return list;
	}
	
	public ArrayList<String> countPerDay()
	{
		//initialize variables
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i++)
		{
			//count=1 for the first time stamp
			count = 1;
			//get the current calendar object
			Calendar cal1 = time.get(i);
			
			//format for the output as a string
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				//get the next calendar object for comparison
				Calendar cal2 = time.get(j);
				//check if during the same day
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))
				{
					//increase the count
					count++;
					//increase index i to skip this calendar object later when exiting this loop
					i++;
				}
			}
			//add the result to the output list that will be sent to statistics page
			list.add(format + " -- " + Integer.toString(count));
		}
		return list;
	}
	
	public ArrayList<String> countPerWeek()
	{
		//initialize variables
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i++)
		{
			//count=1 for the first time stamp
			count = 1;
			//get the current calendar object
			Calendar cal1 = time.get(i);
			
			//format for the output as a string
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				//get the next calendar object for comparison
				Calendar cal2 = time.get(j);
				//check if during the same week
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				{
					//increase the count
					count++;
					//increase index i to skip this calendar object later when exiting this loop
					i++;
				}
			}
			//add the result to the output list that will be sent to statistics page
			list.add("Week of " + format + " -- " + Integer.toString(count));
		}
		return list;
	}
	
	public ArrayList<String> countPerMonth()
	{
		//initialize variables
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i++)
		{
			//count=1 for the first time stamp
			count = 1;
			//get the current calendar object
			Calendar cal1 = time.get(i);
			
			//format for the output as a string
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				//get the next calendar object for comparison
				Calendar cal2 = time.get(j);
				//check if during the same month
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
				{
					//increase the count
					count++;
					//increase index i to skip this calendar object later when exiting this loop
					i++;
				}
			}
			//add the result to the output list that will be sent to statistics page
			list.add("Month of " + format + " -- " + Integer.toString(count));
		}
		return list;
	}
	
}
