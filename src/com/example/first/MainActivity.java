package com.example.first;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * MainActivity is specified as the launcher and main activity in AndroidManifest.xml
 * Consequently this will be the first class to be instantiated and there will be a launcher
 * in the mobile devices application list.
 * 
 * @author carl & mikey
 *
 */
public class MainActivity extends Activity {

	// Class variables
	
	String input; // A variable to hold the total bill amount.
	
	/**
	 * Overriding default android method from Activity, this is called at the start of this activity and as
	 * MainActivity is specified as the launcher in AndroidManifest.xml, it'll be the first thing to run.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* assign the layout "activity_main" to this activity. details for how things should be displayed initially
           will  be found in this xml found in res/layout/ */
        setContentView(R.layout.activity_main);
 
    }
    
    /**
     * I think this refers to Androids little "three dot" settings/options menu in the at the top of most apps.
     * We need to work out what this does.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**
     * Called when the user touches the button.
     */
    public void sendMessage(View view) {
        // Do something in response to button click
    	
    	System.out.println("Yo Mumma");
    	
    	// Grabs the EditText from our layout by using it's id totalBillS1
    	EditText editText = (EditText) findViewById(R.id.totalBillS1);
    	// Converts it from an EditText View object to just the string value it contains.
    	input = editText.getText().toString();
    	
    	System.out.println(input +" this");
    	
    	// if the user enters nothing or the variable is somehow not assigned to anything or when the value entered is equal to 0.0
    	if ("".equals(input)||input==null||Double.parseDouble(input)==0.0)
    	{
    		// Grabs the current state of our application.
    		Context context = getApplicationContext();
    		
    		// Store to display in our toast.
    		CharSequence text = "Nothing in life is free, enter the amount on your bill.";
    		
    		/* The length of time our toast should display for, making use of a constant from the Toast class
    		so it behaves the same as other android toasts.*/
    		int duration = Toast.LENGTH_SHORT;
    		
    		// Pass the parameters defined above to a newly instantiated Toast object and display it.
    		Toast toast = Toast.makeText(context,text,duration);
    		toast.show();
    	}
    	// if the use enters a ridiculously low amount (less than a pound)
    	else if (Double.parseDouble(input)<1.0)
    	{
    		// Creates and displays a toast as above
    		Context context = getApplicationContext();
    		CharSequence text = "It is pointless splitting this bill...";
    		int duration = Toast.LENGTH_SHORT;
    		
    		Toast toast = Toast.makeText(context,text,duration);
    		toast.show();
    	}
    	// All other values
    	else
    	{   
    		/* Creates an intent in order to transition to a different activity.
    		   This class and the class "Second" are passed in as parameters */
	    	Intent intent = new Intent(this, Second.class);
	    	
	    	// An extra value is included with the intent we just created, the string that we captured from our edit text earlier. 
	        intent.putExtra("pass",input);
	        
	        // We then a call a function which launches new activities specifying which activity using our intent we have just created. 
	        startActivity(intent);
    	}
        
    }
}
