package com.example.projectapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class StudentHomePage extends ActionBarActivity implements OnClickListener{

	Button my_profile, courses, leavereq;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_home);
		
		my_profile = (Button)findViewById(R.id.button1);
		courses = (Button)findViewById(R.id.button2);
		leavereq = (Button)findViewById(R.id.button3);
		my_profile.setOnClickListener(this);
		courses.setOnClickListener(this);
		leavereq.setOnClickListener(this);
		
	}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == courses)
		{
			startActivity(new Intent(StudentHomePage.this,CoursesList.class));
		}
		if(v == leavereq)
		{
			startActivity(new Intent(StudentHomePage.this,StudentLeaveForm.class));
		}
		if(v == my_profile)
		{
			startActivity(new Intent(StudentHomePage.this,ProfilePage.class));
		}
	}
}
