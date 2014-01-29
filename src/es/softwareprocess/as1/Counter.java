package es.softwareprocess.as1;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import android.util.Log;

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
			
			format = (new SimpleDateFormat("MMM d HH:mmaa")).format(cal.getTime());
			Calendar newCal = (Calendar) cal.clone();
			newCal.set(Calendar.HOUR, hour+1);
			//Log.w("Date:", format);
			//format = (new SimpleDateFormat("MMM d HH:mmaa")).format(newCal.getTime());
			//Log.w("Date2:", format);
			//Log.w("thecount", Integer.toString(count));
			//Log.w("thehour", Integer.toString(hour));
			
			for(int j=i+1; j < time.size(); j++)
			{
				//Log.w("thecount", Integer.toString(count));
				//check if pass the hour
				if(time.get(j).before(newCal))
				{
					count++;
					//Log.w("thecount", Integer.toString(count));
				}
			}
			list.add(format + ": " + Integer.toString(count));
			//Log.w("added", "pass");
		}
		
		
		//Log.w("sizelist", Integer.toString(list.size()));
		
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
