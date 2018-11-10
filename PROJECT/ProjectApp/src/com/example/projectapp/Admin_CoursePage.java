package com.example.projectapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class Admin_CoursePage extends ActionBarActivity{

	EditText edt_course;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_addcourse);
	
		edt_course = (EditText)findViewById(R.id.editText1);
	}
	
	public void OnSave(View view)
	{
		String course = edt_course.getText().toString();
		
		String type = "course";
		
		BackTask bc = new BackTask(this);
		bc.execute(type,course);
		
	}
	
	class BackTask extends AsyncTask<String, Void, String>
	{
		Context context;
		AlertDialog alertDialog;
		
		public BackTask(Context cntx) {
			// TODO Auto-generated constructor stub
			context = cntx;
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			String type = params[0];
			String course_url = "http://172.16.1.18/myapp/insert_course.php";
			
			if(type.equals("course"))
			{
				String course = params[1];
				URL url;
				try {
					url = new URL(course_url);
					HttpURLConnection htp = (HttpURLConnection)url.openConnection();
					htp.setRequestMethod("POST");
					htp.setDoInput(true);
					htp.setDoOutput(true);
					OutputStream os = htp.getOutputStream();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
					String post_data = URLEncoder.encode("course","UTF-8")+"="+URLEncoder.encode(course,"UTF-8");
					bw.write(post_data);
					bw.flush();
					bw.close();
					os.close();
					
					InputStream ist = htp.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(ist,"iso-8859-1"));
					String result = "";
					String line = "";
					while((line = br.readLine())!= null)
					{
						result += line;
					}
					br.close();
					ist.close();
					htp.disconnect();
					return result;
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			alertDialog = new AlertDialog.Builder(context).create();
			alertDialog.setTitle("Status");
		}
		
		@Override
		protected void onPostExecute(String result) {
			alertDialog.setMessage(result);
			alertDialog.show();
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
	}
}
