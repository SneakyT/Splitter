package com.example.first;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
		String input;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /** Called when the user touches the button */
    public void sendMessage(View view) {
        // Do something in response to button click
    	System.out.println("Yo Mumma");
    	
    	EditText editText = (EditText) findViewById(R.id.totalBillS1);
    	//input = editText.toString();
    	input = editText.getText().toString();
    	
    	System.out.println(input +" this");
    	
    	if ("".equals(input)||input==null||Double.parseDouble(input)==0.0)
    	{
    		Context context = getApplicationContext();
    		CharSequence text = "Nothing's Free BITCH";
    		int duration = Toast.LENGTH_SHORT;
    		
    		Toast toast = Toast.makeText(context,text,duration);
    		toast.show();
    	}	
    	else if (Double.parseDouble(input)<1.0)
    	{
    		Context context = getApplicationContext();
    		CharSequence text = "Dont be so cheap...";
    		int duration = Toast.LENGTH_SHORT;
    		
    		Toast toast = Toast.makeText(context,text,duration);
    		toast.show();
    	}	
    	else
    	{    	
    		System.out.println("Yo");
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("pass",input);
        startActivity(intent);
    	}
        
    }
}
