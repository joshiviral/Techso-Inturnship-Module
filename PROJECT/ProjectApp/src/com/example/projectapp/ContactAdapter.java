package com.example.projectapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter{

	List list = new ArrayList();
	
	public ContactAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

	
	public void add(Course object) {
		// TODO Auto-generated method stub
		super.add(object);
		list.add(object);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View row;
		row = convertView;
		ContactHolder ch;
		if(row == null)
		{
			LayoutInflater lf = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = lf.inflate(R.layout.rowlayout, parent, false);	
			ch = new ContactHolder();
			ch.txtname = (TextView)row.findViewById(R.id.textView1);
			ch.txtusernm = (TextView)row.findViewById(R.id.textView2);
			
			row.setTag(ch);
			
		}
		else
		{
			ch = (ContactHolder)row.getTag();
		}
		Course ct = (Course)this.getItem(position);
		ch.txtname.setText(ct.getName());
		ch.txtusernm.setText(ct.getUsername());
		
		
		return row;
	}
	
	static class ContactHolder
	{
		TextView txtname, txtusernm;
	}
}

