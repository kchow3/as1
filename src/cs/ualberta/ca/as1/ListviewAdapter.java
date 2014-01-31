package cs.ualberta.ca.as1;

import android.content.Context;
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

/*
 * ListviewAdapter class that handles the view of the counters
 * and adds functionality to the app through buttons on the 
 * custom listview row that has buttons that interact with the
 * counter controller to manipulates the counters.
 * The design of this class uses a custom listview row and buttons
 * in the row and accesses methods in the counter controller so
 * that the app is able to create a custom view and be able to
 * create custom functionality through the controller
 */
public class ListviewAdapter extends ArrayAdapter<Counter>
{
	private Context context;
	//holder for the buttons in the row
	private ViewHolder holder;
	//counterlist to send to controller
	private CounterList countersArrayList;
	
	//construct a ListviewAdapter that sets up the listview custom row
	public ListviewAdapter(Context context, CounterList countersArrayList)
	{
		super(context, R.layout.listview_row, countersArrayList.getCounterList());
		
		this.context = context;
		this.countersArrayList = countersArrayList;
	}
	 
	//class that contains the buttons and text fields of the custom row
	private static class ViewHolder 
	{
        TextView countView;
        EditText nameView;
        Button incrementButton;
		Button resetButton;
		Button deleteButton;
    }
	
	//method that sets up the view
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//declare a new holder
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
		//set on edit listner for name edit and tag for position
		holder.nameView.setOnEditorActionListener(editName);
		holder.nameView.setTag(position);
		
		//set onclick listners for buttons and the tag for position
		holder.incrementButton.setOnClickListener(incrementBtnClick);
        holder.incrementButton.setTag(position);
        holder.resetButton.setOnClickListener(resetBtnClick);
        holder.resetButton.setTag(position);
        holder.deleteButton.setOnClickListener(deleteBtnClick);
        holder.deleteButton.setTag(position);
        
        //set the holder
        rowView.setTag(holder);
		
		return rowView;
	}
	
	//method to getCount
	@Override
	public int getCount() 
	{
        return countersArrayList.size();
    }
	
	//method to refresh the listview
	public void updateListview(CounterList newCounterList)
	{
		countersArrayList = newCounterList;
		notifyDataSetChanged();
		CounterController cntrl = new CounterController(countersArrayList);
		cntrl.saveCounters(getContext());
	}
	
	//setup the increment button
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
    
	//setup reset button
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
	
	//setup delete button
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
	
	//setup edit name field
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
