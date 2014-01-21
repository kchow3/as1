package es.softwareprocess.as1;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.app.ListActivity;
import android.widget.ListView;


public class MainActivity extends Activity{
	
	ArrayList<Counter> countersArrayList;
	
    @Override
    protected void onCreate(Bundle icicle) {
    	
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        countersArrayList = new ArrayList<Counter>();
        //need to implement save/resume data
        
        //setup listview
        ListviewAdapter adapter = new ListviewAdapter(this, countersArrayList);
        ListView listview = (ListView) findViewById(R.id.counterListView);
        
        //setup adapter
        listview.setAdapter(adapter);
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
