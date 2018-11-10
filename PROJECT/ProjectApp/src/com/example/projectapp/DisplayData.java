package com.example.projectapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;


public class DisplayData extends ActionBarActivity{

	String json_string;
	JSONObject jsonobj;
	JSONArray jsonarray;
	ContactAdapter cd;
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_course);
		
		list = (ListView)findViewById(R.id.listView1);
		cd = new ContactAdapter(this, R.layout.rowlayout);
		list.setAdapter(cd);
		
		json_string = getIntent().getExtras().getString("json_data");
		
		try {
			jsonobj = new JSONObject(json_string);
			jsonarray = jsonobj.getJSONArray("jsonresult");
			
			int count =0;
			String name, username;
			
			while(count<jsonarray.length())
			{
				JSONObject jo = jsonarray.getJSONObject(count);
				name = jo.getString("name");
				username = jo.getString("username");
				Course con = new Course(name, username);
				cd.add(con);
				count++;
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
