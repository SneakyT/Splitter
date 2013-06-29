package com.example.first;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * MainActivity is specified as the launcher and main activity in AndroidManifest.xml
 * Consequently this will be the first class to be instantiated and there will be a launcher
 * in the mobile devices application list.
 * 
 * @author carl & mikey
 * @version 1.1
 *
 */
public class MainActivity extends Activity {

	// Class variables
	
	String strValueOfBill; // A variable to hold the total bill amount.
	boolean blRouletteTip; // a variable holding the decision on whether roulette tip functionality should be used.
	boolean blIncludeTip; // a variable holding the decision on whether include tip functionality should be used.
	
	/**
	 * Overriding default android method from Activity, this is called at the start of this activity and as
	 * MainActivity is specified as the launcher in AndroidManifest.xml, it'll be the first thing to run.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Always call super to restore previous state of this activity if resuming. (It's an android thing)
    	super.onCreate(savedInstanceState);
        
        /* assign the layout "activity_main" to this activity. details for how things should be displayed initially
           will  be found in this xml found in res/layout/ */
        setContentView(R.layout.activity_main);
 
    }
    
    /**
     * This refers to Androids little "three dot" settings/options menu in the at the top of most apps.
     * @param menu
     */
    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu); // TODO work out what this line does exactly.
        return true;
    }
    
    /**
     * Messy function which listens for Checkbox click events. If one is selected it un-selects the other
     * and assigns appropriate values to boolean class variables which store the tip settings.
     * @param view
     */
    public void onCheckboxClicked(View view) {
    	// TODO: Make this function neater
    	
    	// Is the view that threw the event now checked?
        boolean checked = ((CheckBox) view).isChecked();
        
        // Switching on the view's id to identify which checkbox was clicked
        switch(view.getId()) {
            case R.id.includeTipCheck:
            	// If include tip in total bill checkbox has just been checked.
            	if (checked)
                {
            		CheckBox checkBox = (CheckBox)findViewById(R.id.rouletteTipCheck);
            		checkBox.setChecked(false);
            		blIncludeTip = true;
            		blRouletteTip = false;
            		System.out.println("Current state of checkboxes... \n Include Tip: " + blIncludeTip +" Roulette Tip: " + blRouletteTip);
                }
            	// If include tip in total bill checkbox has just been UNchecked.
                else
                {
                	blIncludeTip = false;
                	System.out.println("Current state of checkboxes... \n Include Tip: " + blIncludeTip +" Roulette Tip: " + blRouletteTip);
                }
                break;
            case R.id.rouletteTipCheck:
            	// If assign tip in a roulette style checkbox has just been checked.
            	if (checked)
            	{
            		CheckBox checkBox = (CheckBox)findViewById(R.id.includeTipCheck);
            		checkBox.setChecked(false);
            		blIncludeTip = false;
            		blRouletteTip = true;
            		System.out.println("Current state of checkboxes... \n Include Tip: " + blIncludeTip +" Roulette Tip: " + blRouletteTip);
            	}
            	// If assign tip in a roulette style checkbox has just been UNchecked.
                else
                {
                	blRouletteTip = false;
                	System.out.println("Current state of checkboxes... \n Include Tip: " + blIncludeTip +" Roulette Tip: " + blRouletteTip);
                }
                break;
        }
    }
    
    /**
     * Called when the user touches the button.
     * @param view
     */
    public void sendMessage(View view) {
        // Do something in response to button click
    	System.out.println("Yo Mumma");
    	
    	// Grabs the EditText from our layout by using it's id totalBillS1
    	EditText editText = (EditText) findViewById(R.id.totalBillS1);
    	// Converts it from an EditText View object to just the string value it contains.
    	strValueOfBill = editText.getText().toString();
    	
    	
    	
    	// if the user enters nothing or the variable is somehow not assigned to anything or when the value entered is equal to 0.0
    	if ("".equals(strValueOfBill)||strValueOfBill==null||Double.parseDouble(strValueOfBill)==0.0)
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
    	else if (Double.parseDouble(strValueOfBill)<1.0)
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
	    	
	    	/* Extra values are included with the intent we just created, the string that we captured from our edit text earlier
	    	   as well as the current states of the tip checkboxes*/
	        intent.putExtra("pass",strValueOfBill); // TODO make name of this 
	        intent.putExtra("blRouletteTip", blRouletteTip);
	        intent.putExtra("blIncludeTip", blIncludeTip);
	        
	        // We then a call a function which launches new activities specifying which activity using our intent we have just created. 
	        startActivity(intent);
    	}
        
    }
}
