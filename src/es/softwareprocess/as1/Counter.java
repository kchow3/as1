package es.softwareprocess.as1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Counter implements Serializable
{
	//serialversionUID
	private static final long serialVersionUID = 547813201;
	
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Calendar> getTime() {
		return time;
	}

	public void setTime(ArrayList<Calendar> time) {
		this.time = time;
	}
	
	public void increaseCount()
	{
		this.count++;
		Calendar date = Calendar.getInstance();
		this.time.add(date);
	}

	public void clearTime()
	{
		this.time.clear();
	}
	
	public ArrayList<String> countPerHour()
	{
		ArrayList<String> list = new ArrayList<String>();
		int hour = 0;
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i=count+1)
		{
			count = 1;
			Calendar cal = time.get(i);
			hour = cal.get(Calendar.HOUR);
			
			format = (new SimpleDateFormat("MMM d, HH:mmaa")).format(cal.getTime());
			Calendar newCal = (Calendar) cal.clone();
			newCal.set(Calendar.HOUR, hour+1);
			
			for(int j=i+1; j < time.size(); j++)
			{
				//check if pass the hour
				if(time.get(j).before(newCal))
				{
					count++;
				}
			}
			list.add(format + " -- " + Integer.toString(count));
		}
		
		return list;
	}
	
	public ArrayList<String> countPerDay()
	{
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i=count+1)
		{
			count = 1;
			Calendar cal1 = time.get(i);
			
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				Calendar cal2 = time.get(j);
				//check if during the same day
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))
				{
					count++;
				}
			}
			list.add(format + " -- " + Integer.toString(count));
		}
		
		return list;
	}
	
	public ArrayList<String> countPerWeek()
	{
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i=count+1)
		{
			count = 1;
			Calendar cal1 = time.get(i);
			
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				Calendar cal2 = time.get(j);
				//check if during the same day
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				{
					count++;
				}
			}
			list.add("Week of " + format + " -- " + Integer.toString(count));
		}
		
		return list;
	}
	
	public ArrayList<String> countPerMonth()
	{
		ArrayList<String> list = new ArrayList<String>();
		String format = "";
		int count = 0;

		for(int i=0; i < time.size(); i=count+1)
		{
			count = 1;
			Calendar cal1 = time.get(i);
			
			format = (new SimpleDateFormat("MMM d")).format(cal1.getTime());
			
			for(int j=i+1; j < time.size(); j++)
			{
				Calendar cal2 = time.get(j);
				//check if during the same day
				if( cal1.get(Calendar.YEAR ) == cal2.get(Calendar.YEAR) &&
						cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
				{
					count++;
				}
			}
			list.add("Month of " + format + " -- " + Integer.toString(count));
		}
		
		return list;
	}
	
}
