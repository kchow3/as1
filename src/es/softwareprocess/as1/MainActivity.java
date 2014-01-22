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
	
	ArrayList<Counter> countersArrayList;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        setContentView(R.layout.main);
        countersArrayList = new ArrayList<Counter>();
        CounterList counterList = new CounterList();
        countersArrayList = counterList.getCounterList();
        
        //setup listview
        ListviewAdapter adapter = new ListviewAdapter(this, countersArrayList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup adapter
        listview.setAdapter(adapter);
        
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(addBtnClick);
      
    }
    
    private OnClickListener addBtnClick = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	Counter aCounter = new Counter();
	    	CounterController cntrl = new CounterController();
	    	cntrl.addCounter(aCounter);
	    }
	};
    
    @Override
    public void onResume()
    {
    	super.onResume();
    }
    
    @Override
    public void onPause()
    {
    	super.onPause();
    }
    
}
