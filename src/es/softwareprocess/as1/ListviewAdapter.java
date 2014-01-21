package es.softwareprocess.as1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

public class ListviewAdapter extends ArrayAdapter<Counter>{

	private final Context context;
	private ViewHolder holder;
	private final ArrayList<Counter> countersArrayList;
	
	public ListviewAdapter(Context context, ArrayList<Counter> countersArrayList)
	{
		super(context, R.layout.listview_row, countersArrayList);
		
		this.context = context;
		this.countersArrayList = countersArrayList;
	}
	 
	private static class ViewHolder 
	{
         TextView nameView, countView;
         Button incrementButton, resetButton, deleteButton;
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
		holder.nameView = (TextView) rowView.findViewById(R.id.nameView);
		holder.countView = (TextView) rowView.findViewById(R.id.countView);
		holder.incrementButton = (Button) rowView.findViewById(R.id.incrementButton);
		holder.resetButton = (Button) rowView.findViewById(R.id.resetButton);
		holder.deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
		
		//set text for textview
		holder.nameView.setText(countersArrayList.get(position).getName());
		holder.countView.setText(Integer.toString(countersArrayList.get(position).getCount()));
		//TODO create onclick listners for button clicks
		
		holder.incrementButton.setOnClickListener(incrementBtnClick);
        holder.incrementButton.setTag(position);
		
		return rowView;
	}
	
	@Override
    public Counter getItem(int position) {
        // TODO Auto-generated method stub
        return countersArrayList.get(position);
    }
	
	private OnClickListener incrementBtnClick = new OnClickListener() 
	{
	    public void onClick(View v)
	    {
	    	
	    }
	};
    
    public void deleteClick(View v)
    {
    	
    }
    
    public void resetClick(View v)
    {
    	
    }
	
}
