package cs.ualberta.ca.as1;

import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;

/*
 * MainActivity class extends activity and holds the main
 * app page that is started when the app is launched.
 * This activity contains the counters view which is contained
 * in the listview, the "Enter Name" input for creating counters
 * and the statistics button to start a second activity
 * consisting of the counter statistics page. This also loads
 * the previous counterlist on the onResume() method.
 * The design of this class is to setup the counters page which
 * consists of mainly the view for the counters that makes up
 * a lot of the app's functionality
 */
public class MainActivity extends Activity{
	
	//the string for passing a arraylist through extra in an intent
	public final static String EXTRA_STATS = "cs.ualberta.ca.as1.stats";

	//counterlist that is first initialized on the onCreate() method
	private CounterList counterList;
	//listview adapter for the counters
	private ListviewAdapter viewAdapter;
	//edit text field for setting name for counter
	private EditText nameInput;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        //set the main view as main.xml
        setContentView(R.layout.main);
        //initialize the counterlist
        counterList = new CounterList();
        
        //setup listview
        viewAdapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup the edit text field
        nameInput = (EditText)findViewById(R.id.counterName);
        
        //setup adapter
        listview.setAdapter(viewAdapter);
      
    }
    
    /*
     * method to handle the add counter button
     * which takes the name in the edit text field
     * and creates and new counter and sorts the list
     * of the current counters and updates the listview
     */
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
    
    /*
     * method to handle the stats button which starts
     * a new activity by sending the stats arraylist of
     * string to the activity through an intent
     */
    public void statsBtnClick(View v)
    {
    	CounterController cntrl = new CounterController(counterList);
    	cntrl.sortCounters();
    	ArrayList<String> list = cntrl.loadStats();
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
        
        //get the file of the saved counters that are serialized
        File file = this.getApplicationContext().getFileStreamPath("file.sav");
        //check if it is the first time running the app to see if file exists
        if(file.exists())
        {
        	//if the file exists load the previous counters
        	CounterController cntrl = new CounterController(counterList);
        	counterList.setCounterList(cntrl.loadCounters(this.getApplicationContext()));
        	cntrl.sortCounters();
        }
        //refresh the listview
    	viewAdapter.updateListview(counterList);
    }
}
