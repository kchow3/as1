package es.softwareprocess.as1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Context;
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
    /*
    public void saveCounters() {
		try 
		{
			FileOutputStream fos = openFileOutput("file.sav", Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(counterList.getCounterList());
			oos.flush();
			oos.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}

	}
    
	public ArrayList<Counter> loadCounters() {
		try
		{
			FileInputStream fis = openFileInput("file.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			return (ArrayList<Counter>)o;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
    */
}
