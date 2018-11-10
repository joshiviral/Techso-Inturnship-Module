package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends ActionBarActivity implements OnClickListener{

	EditText usernm, passwrd;
	Button btn_login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpage);
	
		btn_login = (Button)findViewById(R.id.button1);
		usernm = (EditText)findViewById(R.id.editText1);
		passwrd = (EditText)findViewById(R.id.editText2);
		btn_login.setOnClickListener(this);
	
	}
	


	@Override
	public void onClick(View v) {
	
		if(v == btn_login)
		{
			String u = usernm.getText().toString();
			String p = passwrd.getText().toString();
			
			if(u.equals("admin") && p.equals("admin"))
			{
				startActivity(new Intent(LoginPage.this,HomePage.class));
			}
			else if(u.equals("") && p.equals(""))
			{
				startActivity(new Intent(LoginPage.this,StudentHomePage.class));
			}
			
		}
	}

	
}


