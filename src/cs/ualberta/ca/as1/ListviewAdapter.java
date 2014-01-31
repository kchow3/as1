package cs.ualberta.ca.as1;

import es.softwareprocess.as1.R;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TextView.OnEditorActionListener;

public class ListviewAdapter extends ArrayAdapter<Counter>{

	private Context context;
	private ViewHolder holder;
	private CounterList countersArrayList;
	
	public ListviewAdapter(Context context, CounterList countersArrayList)
	{
		super(context, R.layout.listview_row, countersArrayList.getCounterList());
		
		this.context = context;
		this.countersArrayList = countersArrayList;
	}
	 
	private static class ViewHolder 
	{
         TextView countView;
         EditText nameView;
         Button incrementButton;
		Button resetButton;
		Button deleteButton;
    }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		holder = new ViewHolder();
		
		//create inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//get rowView from inflater
		View rowView = null;
		rowView = inflater.inflate(R.layout.listview_row, parent, false);
		
		//get name, counter and buttons views from the rowView
		holder.nameView = (EditText) rowView.findViewById(R.id.nameView);
		holder.countView = (TextView) rowView.findViewById(R.id.countView);
		holder.incrementButton = (Button) rowView.findViewById(R.id.incrementButton);
		holder.resetButton = (Button) rowView.findViewById(R.id.resetButton);
		holder.deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
		
		//set text for textview
		holder.countView.setText(Integer.toString(countersArrayList.get(position).getCount()));
		
		//set text for edit text
		holder.nameView.setText(countersArrayList.get(position).getName());
		//set on edit listner for name edit
		holder.nameView.setOnEditorActionListener(editName);
		holder.nameView.setTag(position);
		
		//set onclick listners for buttons
		holder.incrementButton.setOnClickListener(incrementBtnClick);
        holder.incrementButton.setTag(position);
        holder.resetButton.setOnClickListener(resetBtnClick);
        holder.resetButton.setTag(position);
        holder.deleteButton.setOnClickListener(deleteBtnClick);
        holder.deleteButton.setTag(position);
        
        rowView.setTag(holder);
		
		return rowView;
	}
	
	@Override
	public int getCount() 
	{
        return countersArrayList.size();
    }
	
	public void updateListview(CounterList newCounterList)
	{
		countersArrayList = newCounterList;
		notifyDataSetChanged();
		CounterController cntrl = new CounterController(countersArrayList);
		cntrl.saveCounters(getContext());
	}
	
	private OnClickListener incrementBtnClick = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	int i = (Integer) v.getTag();
	    	CounterController cntrl = new CounterController(countersArrayList);
	    	Counter aCounter = countersArrayList.get(i);
	    	cntrl.incrementCount(aCounter);
	    	updateListview(countersArrayList);
	    }
	};
    
	private OnClickListener resetBtnClick = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	int i = (Integer) v.getTag();
	    	CounterController cntrl = new CounterController(countersArrayList);
	    	Counter aCounter = countersArrayList.get(i);
	    	cntrl.resetCount(aCounter);
	    	cntrl.sortCounters();
	    	updateListview(countersArrayList);
	    }
	};
	
	private OnClickListener deleteBtnClick = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	int i = (Integer) v.getTag();
	    	CounterController cntrl = new CounterController(countersArrayList);
	    	Counter aCounter = countersArrayList.get(i);
	    	cntrl.deleteCounter(aCounter);
	    	cntrl.sortCounters();
	    	updateListview(countersArrayList);
	    }
	};
	
	private OnEditorActionListener editName = new OnEditorActionListener() 
	{
	    @Override
	    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) 
	    {
	        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
	                actionId == EditorInfo.IME_ACTION_DONE ||
	                event.getAction() == KeyEvent.ACTION_DOWN &&
	                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) 
	        {
	        	int i = (Integer) v.getTag();
	        	String name = v.getText().toString();
	        	CounterController cntrl = new CounterController(countersArrayList);
	        	
		    	Counter aCounter = countersArrayList.get(i);
		    	cntrl.renameCounter(aCounter, name);
		    	updateListview(countersArrayList);
	        }
	        return false;
	    }
	};
	
}
