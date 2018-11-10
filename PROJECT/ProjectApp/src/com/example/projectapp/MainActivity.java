package com.example.projectapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Thread timer = new Thread()
		{
			public void run() {
				try {
					sleep(1000);
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					startActivity(new Intent(MainActivity.this,LoginPage.class));
				}
			}
		};
		timer.start();
	}

	
}
