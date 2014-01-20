package es.softwareprocess.as1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

public class ListviewAdapter extends ArrayAdapter<Counter>{

	private final Context context;
	private final ArrayList<Counter> countersArrayList;
	
	public ListviewAdapter(Context context, ArrayList<Counter> countersArrayList)
	{
		super(context, R.layout.listview_row, countersArrayList);
		
		this.context = context;
		this.countersArrayList = countersArrayList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//create inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//get rowView from inflater
		View rowView = null;
		rowView = inflater.inflate(R.layout.listview_row, parent, false);
		
		//get name, counter and buttons views from the rowView
		TextView nameView = (TextView) rowView.findViewById(R.id.nameView);
		TextView countView = (TextView) rowView.findViewById(R.id.countView);
		Button incrementButton = (Button) rowView.findViewById(R.id.incrementButton);
		Button resetButton = (Button) rowView.findViewById(R.id.resetButton);
		Button deleteButton = (Button) rowView.findViewById(R.id.deleteButton);
		
	}
	
}
