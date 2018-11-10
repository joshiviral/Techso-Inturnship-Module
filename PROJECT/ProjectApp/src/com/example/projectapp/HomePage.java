package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomePage extends ActionBarActivity implements OnClickListener{

	Button add_stu, add_fac, add_course, leave, logout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		add_stu = (Button)findViewById(R.id.button1);
		add_fac = (Button)findViewById(R.id.button2);
		add_course = (Button)findViewById(R.id.button3);
		leave = (Button)findViewById(R.id.button5);
		logout = (Button)findViewById(R.id.button6);
		
		add_stu.setOnClickListener(this);
		add_fac.setOnClickListener(this);
		add_course.setOnClickListener(this);
		leave.setOnClickListener(this);
		logout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == add_stu)
		{
			startActivity(new Intent(HomePage.this,Admin_StudentregPage.class));
		}

		if(v == add_fac)
		{
			startActivity(new Intent(HomePage.this,Admin_FacultyregPage.class));
		}
		
		if(v == add_course)
		{
			startActivity(new Intent(HomePage.this,Admin_CoursePage.class));
		}
		if(v == leave)
		{
			startActivity(new Intent(HomePage.this,LeaveFile.class));
		}
		if(v == logout)
		{
			startActivity(new Intent(HomePage.this,LoginPage.class));
		}
	}
}
