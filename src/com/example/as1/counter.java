package com.example.as1;
import java.util.*;
import java.

public class counter {
	
	private String name;
	private int count;
	private Arraylist<Date> time;
	
	//Constructor method
	public counter(String counter_name)
	{
		this.name = counter_name;
		this.count = 0;
		this.time = new Date[]();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public Date[] getDate()
	{
		return time;
	}
	
	public void increase()
	{
		count++;
	}
	
	public void change_name(String new_name)
	{
		this.name = new_name;
	}
	
	public void reset_counter()
	{
		this.count = 0;
		this.time = new
	}

}
