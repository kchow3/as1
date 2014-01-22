package es.softwareprocess.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity{
	
	CounterList counterList;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        setContentView(R.layout.main);
        CounterList counterList = new CounterList();
        
        //setup listview
        ListviewAdapter adapter = new ListviewAdapter(this, counterList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup adapter
        listview.setAdapter(adapter);
        
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new OnClickListener() 
    	{
    	    public void onClick(View v)
    	    {
    	    	Counter aCounter = new Counter();
    	    	CounterController cntrl = new CounterController();
    	    	cntrl.addCounter(aCounter);
    	    }
    	});
      
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
