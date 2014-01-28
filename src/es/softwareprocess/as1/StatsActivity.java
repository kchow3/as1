package es.softwareprocess.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;

public class StatsActivity extends Activity {
	
	ArrayAdapter<String> adapter;
	private ArrayList<String> statsList;

	@Override
	protected void onCreate(Bundle icicle) 
	{
		super.onCreate(icicle);
		setContentView(R.layout.activity_stats);
		getInputList();
		adapter= new ArrayAdapter<String>(this, statsList);
	    setListAdapter(adapter);
	}
	
	protected void onResume()
	{
		super.onResume();
		getInputList();
	}
	
	public void countersBtnClick(View v)
	{
	    finish(); 
	}
	
	private void getInputList()
	{
		Intent in = getIntent();
		ArrayList<String> list =(ArrayList<String>) in.getSerializableExtra(MainActivity.EXTRA_STATS);
		statsList.addAll(list);
	}

}
