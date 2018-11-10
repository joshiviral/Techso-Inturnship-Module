package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AppRegisterPAge extends ActionBarActivity implements OnClickListener{

	Button home;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_register);
	
		home = (Button)findViewById(R.id.button2);
		home.setOnClickListener(this);
	}
 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == home)
		{
			startActivity(new Intent(AppRegisterPAge.this,StudentHomePage.class));
		}
	}
}
