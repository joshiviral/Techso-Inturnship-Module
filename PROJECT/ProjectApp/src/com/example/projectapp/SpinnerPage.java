package com.example.projectapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerPage extends ActionBarActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Spinner sp;
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.spinner);
     sp=(Spinner)findViewById(R.id.spinner1);
     adapter=new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listItems);
     
     sp.setAdapter(adapter);

    }
  public void onStart(){
     super.onStart();
     BackTask bt=new BackTask();
     bt.execute();
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
}
