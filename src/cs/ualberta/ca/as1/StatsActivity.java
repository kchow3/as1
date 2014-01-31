package cs.ualberta.ca.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
 * StatsActivity class that hold the counter statistics page
 * and is started from the MainActivity and is passed arraylist
 * of string through an Intent using extras. When closing this
 * page it returns to MainActivity and calls the onResume() method
 * of that class.
 * The design of this class is to create an activity to view the stats
 * and return to counters page after view the stats. This class is updated
 * every time a counter is changed and when transfered to this activity.
 */
public class StatsActivity extends Activity 
{
	//string for accessing the extra of the intent
	public final static String EXTRA_STATS = "cs.ualberta.ca.as1.stats";
	
	//string adapter for the listview
	private ArrayAdapter<String> stringAdapter;
	private ArrayList<String> statsList;

	@Override
	protected void onCreate(Bundle icicle) 
	{
		super.onCreate(icicle);
	}
	
	protected void onResume()
	{
		super.onResume();
		//set the layout to the stats activity
		setContentView(R.layout.activity_stats);
		//call the method to get stats list
		getInputList();
		
		//setup the listview
		ListView statsListView = (ListView) findViewById(R.id.listViewStats);
		//setup adapter
		stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statsList);
		statsListView.setAdapter(stringAdapter);
	}
	
	//method when counter button is clicked the activity is finished and user is returned to main actvity
	public void countersBtnClick(View v)
	{
	    finish(); 
	}
	
	//get the arraylist of string from the intent when starting this activity
	private void getInputList()
	{
		Intent in = getIntent();
		statsList = in.getStringArrayListExtra(EXTRA_STATS);
	}

}
