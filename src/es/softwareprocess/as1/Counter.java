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
		int month, day, hour, min, period;
		String format;
		int count = 0;
		
		for(int i=0; i < time.size(); i=count)
		{
			Calendar cal = (time.get(i)).getInstance();
			month = cal.get(Calendar.MONTH); //zero based
			day = cal.get(Calendar.DAY_OF_MONTH);
			hour = cal.get(Calendar.HOUR);
			min = cal.get(Calendar.MINUTE);
			period = cal.get(Calendar.AM_PM); //AM=0, PM=1
			
			format = new SimpleDateFormat("MMM d HH:mmAA").format(cal);
			Calendar newCal = (Calendar) cal.clone();
			newCal.set(Calendar.HOUR, hour+1);
			
			for(int j=i+1; j < time.size(); j++)
			{
				//check if pass the hour
				if((time.get(j).getInstance()).before(newCal))
				{
					count++;
				}
				else
				{
					list.add(format + ": " + Integer.toString(count));
					break;
				}
			}
		}
		
		return list;
	}
	
	public ArrayList<String> countPerDay()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		return list;
	}
	
	public ArrayList<String> countPerWeek()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		return list;
	}
	
	public ArrayList<String> countPerMonth()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		return list;
	}
	
}
