package com.example.first;

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
        textview.setText("Total Value: £" + dbTotalBillValue); //TODO format currency correctly.
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_second, menu);
        return true;
    }
    
    
    public void sendMessage2(View view)
    {
    	System.out.println("Splitting...");
    	System.out.println(dbTotalBillValue+" Total value of the bill");
    	
    	EditText editText = (EditText) findViewById(R.id.peopleAmountEdit);
    	String strNumberOfPeople = editText.getText().toString();
    	intNumberOfPeople = Integer.parseInt(strNumberOfPeople);
    	
    	System.out.println(intNumberOfPeople+" Number of People");
    	
        Intent intent = new Intent(this, Third.class);
        intent.putExtra("pass2",split(dbTotalBillValue,intNumberOfPeople));
        System.out.println("Value of split function "+ split(dbTotalBillValue,intNumberOfPeople));
        startActivity(intent);
    }
    
    public double split(double bill, int people)
    {
		double output = bill/people;
    	return output;
    	
    }
    	
}
