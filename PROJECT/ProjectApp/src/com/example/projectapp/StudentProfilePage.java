package com.example.projectapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentProfilePage extends ActionBarActivity{

	TextView t1, t2, t3, t4, t5, t6, t7, t8;
	Button btn;
	String JSON_String;
	String json_str;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_profile);
		
		btn = (Button)findViewById(R.id.button1);
		
		t1 = (TextView)findViewById(R.id.textView1);
		t2 = (TextView)findViewById(R.id.textView2);
		t3 = (TextView)findViewById(R.id.textView3);
		t4 = (TextView)findViewById(R.id.textView4);
		t5 = (TextView)findViewById(R.id.textView5);
		t6 = (TextView)findViewById(R.id.textView6);
		t7 = (TextView)findViewById(R.id.textView7);
		t8 = (TextView)findViewById(R.id.textView8);
	}
	
	public void getJson(View view)
	{
		new BackTask().execute();
	}
	
	class BackTask extends AsyncTask<Void, Void, String>
	{

		String json_url;
		
		@Override
		protected void onPreExecute() {
			json_url = "http://172.16.1.18/myapp/getsdetail.php";
		}
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			try
			{
				URL url = new URL(json_url);
				HttpURLConnection htp = (HttpURLConnection)url.openConnection();
				
				InputStream ist = htp.getInputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(ist));
				StringBuilder st = new StringBuilder();
				while((JSON_String = br.readLine())!=null)
				{
					st.append(JSON_String+"\n");
				}
				br.close();
				ist.close();
				htp.disconnect();
				return st.toString().trim();
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			
			t1.setText(result);
			t2.setText(result);
			t3.setText(result);
			t4.setText(result);
			t5.setText(result);
			t6.setText(result);
			t7.setText(result);
			t8.setText(result);
			
			json_str = result;
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
	}
	
}
