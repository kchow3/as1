package es.softwareprocess.as1;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity{
	
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
     	viewAdapter.updateListview(counterList);
     	cntrl.saveCounters(this.getApplicationContext());
    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
        
        //setup listview
        viewAdapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        nameInput = (EditText)findViewById(R.id.counterName);
        
        //setup adapter
        listview.setAdapter(viewAdapter);
        
    	CounterController cntrl = new CounterController(counterList);
    	counterList.setCounterList(cntrl.loadCounters(this.getApplicationContext()));
    	viewAdapter.updateListview(counterList);
    }
}
