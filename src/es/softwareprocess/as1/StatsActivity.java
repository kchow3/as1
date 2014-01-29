package es.softwareprocess.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StatsActivity extends Activity {
	
	ArrayAdapter<String> stringAdapter;
	private ArrayList<String> statsList;

	@Override
	protected void onCreate(Bundle icicle) 
	{
		super.onCreate(icicle);
	}
	
	protected void onResume()
	{
		super.onResume();
		setContentView(R.layout.activity_stats);
		getInputList();
		
		ListView statsListView = (ListView) findViewById(R.id.listViewStats);
		stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statsList);
		statsListView.setAdapter(stringAdapter);
	}
	
	public void countersBtnClick(View v)
	{
	    finish(); 
	}
	
	private void getInputList()
	{
		Intent in = getIntent();
		ArrayList<String> list = (ArrayList<String>) in.getSerializableExtra(MainActivity.EXTRA_STATS);
		statsList.addAll(list);
	}

}
