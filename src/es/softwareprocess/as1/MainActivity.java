package es.softwareprocess.as1;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity{
	
	CounterList counterList;
	ListviewAdapter viewAdapter;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        setContentView(R.layout.main);
        CounterList counterList = new CounterList();
        
        //setup listview
        viewAdapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup adapter
        listview.setAdapter(viewAdapter);
        
        Button addButton = (Button) findViewById(R.id.addButton);
      
    }
    
    public void addBtnClick(View v)
    {
       	Counter aCounter = new Counter();
       	CounterController cntrl = new CounterController();
     	cntrl.addCounter(aCounter);
     	viewAdapter.clear();
     	viewAdapter.addAll(counterList.getCounterList());
     	viewAdapter.notifyDataSetChanged();
    }
    
    @Override
    protected void onResume()
    {
    	super.onResume();
    	CounterController cntrl = new CounterController();
    	cntrl.loadCounters();
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
    	CounterController cntrl = new CounterController();
    	cntrl.saveCounters();
    }
    
}
