package com.example.first;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Second extends Activity {
	
	// Class variables
	
	double dbTotalBillValue;
	int intNumberOfPeople;
	boolean blRouletteTip;
	boolean blIncludeTip;
	EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// Always call super to restore previous state of this activity if resuming. (It's an android thing)
    	super.onCreate(savedInstanceState);
        
    	/* assign the layout "activity_second" to this activity. details for how things should be displayed initially
        will  be found in this xml found in res/layout/ */
        setContentView(R.layout.activity_second);
        
        // Grab the Intent object that was used to trigger this activity's launch.
        Intent intent = getIntent();
        
        // Unpack values from intent and assign them to class variables.
        String strTotalValue = intent.getExtras().getString("pass");
        dbTotalBillValue = Double.parseDouble(strTotalValue);
        blRouletteTip = intent.getExtras().getBoolean("blRouletteTip", false);
        blIncludeTip = intent.getExtras().getBoolean("blIncludeTip", false);
        
        //Grab the text view reserved to display the total bill amount and populate it. 
        TextView textview = (TextView) findViewById(R.id.totalValueS2);
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String formattedBuillValue = formatter.format(dbTotalBillValue);
        
        textview.setText("Total Value: " + formattedBuillValue); //TODO format currency correctly.
        
        editText = (EditText) findViewById(R.id.peopleAmountEdit);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_second, menu);
        return true;
    }
    
    /**
     * Called when the user touches the split button.
     * @param view
     */
    public void sendMessage2(View view)
    {
    	System.out.println("Splitting...");
    	System.out.println(dbTotalBillValue+" Total value of the bill");
    	
    	String strNumberOfPeople = editText.getText().toString();
    	intNumberOfPeople = Integer.parseInt(strNumberOfPeople);
    	System.out.println("Number of People: " + intNumberOfPeople);
    	
    	Intent intent = new Intent(this, Third.class);
        intent.putExtra("pass2",split(dbTotalBillValue,intNumberOfPeople));
        
        System.out.println("Value of split function "+ split(dbTotalBillValue,intNumberOfPeople));
        startActivity(intent);
    }
    
    /**
     * This function encapsulates the entire purpose of the application. It divides the bill between the number of
     * people requested.
     * 
     * @param bill
     * @param people
     * @return
     */
    public double split(double bill, int people)
    {
		double output = bill/people;
    	return output;
    	
    }
    	
}
