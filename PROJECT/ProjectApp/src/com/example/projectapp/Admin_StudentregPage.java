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
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;









import com.example.projectapp.Admin_FacultyregPage.BackWrokTask;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class Admin_StudentregPage extends ActionBarActivity implements OnClickListener{

	EditText from_date, to_date;
	EditText fname, address, contact, email;
	DatePickerDialog datepickerdialog1;
	DatePickerDialog datepicketdailog2;
	
	  ArrayList<String> listItems=new ArrayList<String>();
	  ArrayList<String> listitem1 = new ArrayList<String>();
	  ArrayAdapter<String> adapter;
	  ArrayAdapter<String> adp;
	  Spinner sp, coursesp;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		fname = (EditText)findViewById(R.id.editText1);
		address = (EditText)findViewById(R.id.editText2);
		email = (EditText)findViewById(R.id.editText3);
		contact = (EditText)findViewById(R.id.editText4);
		from_date = (EditText)findViewById(R.id.editText5);
		to_date = (EditText)findViewById(R.id.editText6);
		sp=(Spinner)findViewById(R.id.spinner1);
		coursesp=(Spinner)findViewById(R.id.spinner2);
		
	    adapter=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listItems);
	    sp.setAdapter(adapter);
	    

	    adp=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listitem1);
	    coursesp.setAdapter(adp);

		from_date.setOnClickListener(this);
		to_date.setOnClickListener(this);
		
		prepareDatePickerDailog1();
		preparedDatePickerDailog2();
	}

	public void OnRegister(View view)
	{
		String name = fname.getText().toString();
		String adrs = address.getText().toString();
		String contc = contact.getText().toString();
		String em = email.getText().toString();
		String fac = sp.getSelectedItem().toString();
		String cs = coursesp.getSelectedItem().toString();
		String fdate = from_date.getText().toString();
		String tdate = to_date.getText().toString();
		
		String type = "student";
		
		BackWrokTask bwc = new BackWrokTask(this);
		bwc.execute(type,name,adrs,contc,em,fac,cs,fdate,tdate);
	}
	
	class BackWrokTask extends AsyncTask<String, Void, String>
	{

		Context context;
		AlertDialog alertDialog;
		
		public BackWrokTask(Context cntx) {
			// TODO Auto-generated constructor stub
			context = cntx;
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String type = params[0];
			String course_url = "http://172.16.1.18/myapp/insert_student.php";
			
			if(type.equals("student"))
			{
				String nm = params[1];
				String ad = params[2];
				String cont = params[3];
				String el = params[4];
				String fc = params[5];
				String crs = params[6];
				String fd = params[7];
				String td = params[8];
				
				URL url;
				try {
					url = new URL(course_url);
					HttpURLConnection htp = (HttpURLConnection)url.openConnection();
					htp.setRequestMethod("POST");
					htp.setDoInput(true);
					htp.setDoOutput(true);
					OutputStream os = htp.getOutputStream();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
					String post_data = URLEncoder.encode("nm","UTF-8")+"="+URLEncoder.encode(nm,"UTF-8")+"&"+
							URLEncoder.encode("ad","UTF-8")+"="+URLEncoder.encode(ad,"UTF-8")+"&"+
							URLEncoder.encode("cont","UTF-8")+"="+URLEncoder.encode(cont,"UTF-8")+"&"+
							URLEncoder.encode("el","UTF-8")+"="+URLEncoder.encode(el,"UTF-8")+"&"+
							URLEncoder.encode("fc","UTF-8")+"="+URLEncoder.encode(fc,"UTF-8")+"&"+
							URLEncoder.encode("crs","UTF-8")+"="+URLEncoder.encode(crs,"UTF-8")+"&"+
							URLEncoder.encode("fd","UTF-8")+"="+URLEncoder.encode(fd,"UTF-8")+"&"+
							URLEncoder.encode("td","UTF-8")+"="+URLEncoder.encode(td,"UTF-8");
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
	
	
	 public void onStart(){
	     super.onStart();
	     BackTask bt=new BackTask();
	     bt.execute();
	     BackTask1 bc = new BackTask1();
	     bc.execute();
	  }
	  private class BackTask extends AsyncTask<Void,Void,Void> {
	     ArrayList<String> list;
	     protected void onPreExecute(){
	       super.onPreExecute();
	       list=new ArrayList<String>();
	     }
	     protected Void doInBackground(Void...params){
	       InputStream is=null;
	       String result="";
	       try{
	          HttpClient httpclient=new DefaultHttpClient();
	          HttpPost httppost= new HttpPost("http://172.16.1.18/myapp/spnr1.php");
	          HttpResponse response=httpclient.execute(httppost);
	          HttpEntity entity = response.getEntity();
	          // Get our response as a String.
	          is = entity.getContent();
	       }catch(IOException e){
	          e.printStackTrace();
	       }

	       //convert response to string
	       try{
	          BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));           
	          String line = null;
	          while ((line = reader.readLine()) != null) {
	            result+=line;
	          }
	          is.close();
	          //result=sb.toString();
	       }catch(Exception e){
	          e.printStackTrace();
	       }
	       // parse json data
	       try{
	          JSONArray jArray =new JSONArray(result);
	          for(int i=0;i<jArray.length();i++){
	             JSONObject jsonObject=jArray.getJSONObject(i);
	             // add interviewee name to arraylist
	             list.add(jsonObject.getString("fname"));
	          }
	       }
	       catch(JSONException e){
	          e.printStackTrace();
	       }
	       return null;
	     }
	     protected void onPostExecute(Void result){
	       listItems.addAll(list);
	       adapter.notifyDataSetChanged();
	     }
	  }
	
	  private class BackTask1 extends AsyncTask<Void,Void,Void> {
		     ArrayList<String> list1;
		     protected void onPreExecute(){
		       super.onPreExecute();
		       list1=new ArrayList<String>();
		     }
		     protected Void doInBackground(Void...params){
		       InputStream is=null;
		       String result="";
		       try{
		          HttpClient httpclient=new DefaultHttpClient();
		          HttpPost httppost= new HttpPost("http://172.16.1.18/myapp/course.php");
		          HttpResponse response=httpclient.execute(httppost);
		          HttpEntity entity = response.getEntity();
		          // Get our response as a String.
		          is = entity.getContent();
		       }catch(IOException e){
		          e.printStackTrace();
		       }

		       //convert response to string
		       try{
		          BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));           
		          String line = null;
		          while ((line = reader.readLine()) != null) {
		            result+=line;
		          }
		          is.close();
		          //result=sb.toString();
		       }catch(Exception e){
		          e.printStackTrace();
		       }
		       // parse json data
		       try{
		          JSONArray jArray =new JSONArray(result);
		          for(int i=0;i<jArray.length();i++){
		             JSONObject jsonObject=jArray.getJSONObject(i);
		             // add interviewee name to arraylist
		             list1.add(jsonObject.getString("cname"));
		          }
		       }
		       catch(JSONException e){
		          e.printStackTrace();
		       }
		       return null;
		     }
		     protected void onPostExecute(Void result){
		       listitem1.addAll(list1);
		       adp.notifyDataSetChanged();
		     }
		  }
		
	  
	  
	  
	  
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == from_date)
		{
			datepickerdialog1.show();
		}
		if(v == to_date)
		{
			datepicketdailog2.show();
		}
		
	}

	
	
	public void prepareDatePickerDailog1()
	{
		Calendar c = Calendar.getInstance();
		
		datepickerdialog1 = new DatePickerDialog(this, 0, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				from_date.setText(year+"/"+monthOfYear+"/"+dayOfMonth);
				datepickerdialog1.dismiss();
			}
		}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		
	}
	
	public void preparedDatePickerDailog2()
	{
		Calendar c1 = Calendar.getInstance();
		
		datepicketdailog2 = new DatePickerDialog(this, 0, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view1, int year1, int monthOfYear1,
					int dayOfMonth1) {
				// TODO Auto-generated method stub
				to_date.setText(year1+"/"+monthOfYear1+"/"+dayOfMonth1);
				datepicketdailog2.dismiss();
			}
		}, c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH));
	}
	
	
	
}
