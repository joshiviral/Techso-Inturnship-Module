package com.example.projectapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeaveFile extends ActionBarActivity{

	ListView lst;
	String names[] = {"Viral Joshi", "Chirag Shitole" , "Divyesh Parmar"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secfile);
		
		lst = (ListView)findViewById(R.id.listView1);
		
		ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,names);
		lst.setAdapter(adp);
		
	}
}
