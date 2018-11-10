package com.example.projectapp;

import org.apache.http.cookie.SetCookie;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CoursesList extends ActionBarActivity{

	ListView lst;
	String course[] = {"Android","PHP","Java","Asp.net","Autocad"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secfile);
		
		lst = (ListView)findViewById(R.id.listView1);
		
		ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,course);
		lst.setAdapter(adp);
	}
}
