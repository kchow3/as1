package es.softwareprocess.as1;

import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity{
	
	 public final static String EXTRA_STATS = "es.softwareprocess.as1.stats";
	
	CounterList counterList;
	ListviewAdapter viewAdapter;
	EditText nameInput;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        setContentView(R.layout.main);
        counterList = new CounterList();
        
        //setup listview
        viewAdapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        nameInput = (EditText)findViewById(R.id.counterName);
        
        //setup adapter
        listview.setAdapter(viewAdapter);
      
    }
    
    public void addBtnClick(View v)
    {
    	String name = nameInput.getText().toString();
       	Counter aCounter = new Counter(name);
       	CounterController cntrl = new CounterController(counterList);
     	cntrl.addCounter(aCounter);
     	cntrl.sortCounters();
     	viewAdapter.updateListview(counterList);
     	cntrl.saveCounters(this.getApplicationContext());
     	nameInput.setText("");
    }
    
    public void statsBtnClick(View v)
    {
    	CounterController cntrl = new CounterController(counterList);
    	cntrl.sortCounters();
    	ArrayList<String> list = cntrl.loadStats();
    	Log.w("sizelist", Integer.toString(list.size()));
    	Intent i = new Intent(getApplicationContext(), StatsActivity.class);
    	i.putStringArrayListExtra(EXTRA_STATS, list);
    	startActivity(i); 
    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
        
        //setup listview
        viewAdapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup adapter
        listview.setAdapter(viewAdapter);
        
        File file = this.getApplicationContext().getFileStreamPath("file.sav");
        if(file.exists())
        {
        	CounterController cntrl = new CounterController(counterList);
        	counterList.setCounterList(cntrl.loadCounters(this.getApplicationContext()));
        	cntrl.sortCounters();
        }
    	viewAdapter.updateListview(counterList);
    }
}
