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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.projectapp.Admin_CoursePage.BackTask;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Admin_FacultyregPage extends ActionBarActivity{

	EditText fname, femail, fcontact;
	
	Spinner sp;
	ArrayList<String> listitem = new ArrayList<String>();
	ArrayAdapter<String> adpater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_facreg);
		
		fname = (EditText)findViewById(R.id.editText1);
		femail = (EditText)findViewById(R.id.editText2);
		fcontact = (EditText)findViewById(R.id.editText3);
		
		sp = (Spinner)findViewById(R.id.spinner1);
		adpater = new ArrayAdapter<String>(this, R.layout.spinner_layout,R.id.txt,listitem);
		sp.setAdapter(adpater);
	}
	
	public void OnAssign(View view)
	{
		String name = fname.getText().toString();
		String email = femail.getText().toString();
		String contact = fcontact.getText().toString();
		String cs = sp.getSelectedItem().toString();
		
		String type = "faculty";
		
		BackWrokTask bwc = new BackWrokTask(this);
		bwc.execute(type,name,email,contact,cs);
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
			String course_url = "http://172.16.1.18/myapp/insert_faculty.php";
			
			if(type.equals("faculty"))
			{
				String name = params[1];
				String email = params[2];
				String contact = params[3];
				String coursespecial = params[4];
				
				URL url;
				try {
					url = new URL(course_url);
					HttpURLConnection htp = (HttpURLConnection)url.openConnection();
					htp.setRequestMethod("POST");
					htp.setDoInput(true);
					htp.setDoOutput(true);
					OutputStream os = htp.getOutputStream();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
					String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
							URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
							URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+
							URLEncoder.encode("coursespecial","UTF-8")+"="+URLEncoder.encode(coursespecial,"UTF-8");
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
	
	
	@Override
	public void onStart() {
		super.onStart();
		BackTask bc = new BackTask();
		bc.execute();
	}
	
	private class BackTask extends AsyncTask<Void, Void, Void>
	{

		ArrayList<String> list;
		 @Override
		protected void onPreExecute() {
			super.onPreExecute();
			list = new ArrayList<String>();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			InputStream is = null;
			String result = "";
			try
			{
				HttpClient htpclient = new DefaultHttpClient();
				HttpPost htpost = new HttpPost("http://172.16.1.18/myapp/course.php");
				 HttpResponse response=htpclient.execute(htpost);
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
		             list.add(jsonObject.getString("cname"));
		          }
		       }
		       catch(JSONException e){
		          e.printStackTrace();
		       }
		       return null;
		     }
		     protected void onPostExecute(Void result){
		       listitem.addAll(list);
		       adpater.notifyDataSetChanged();
		     }
		  }
		
	  
	  
}
