package es.softwareprocess.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class StatsActivity extends Activity {
	
	private ArrayList<String> stats;

	@Override
	protected void onCreate(Bundle icicle) 
	{
		super.onCreate(icicle);
		setContentView(R.layout.activity_stats);
		getInputList();
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
		stats.addAll(list);
	}

}
