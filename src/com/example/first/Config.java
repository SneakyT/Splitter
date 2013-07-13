package com.example.first;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Config extends Activity {
	
	// Class variables
	
	double dbTotalBillValue;
	int intNumberOfPeople;
	boolean blRouletteTip;
	boolean blIncludeTip;
	double dbTipValue = 0;
	EditText editText;
	NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// Always call super to restore previous state of this activity if resuming. (It's an android thing)
    	super.onCreate(savedInstanceState);
        
    	/* assign the layout "activity_second" to this activity. details for how things should be displayed initially
        will  be found in this xml found in res/layout/ */
        setContentView(R.layout.activity_config);
        
        // Grab the Intent object that was used to trigger this activity's launch.
        Intent intent = getIntent();
        
        // Unpack values from intent and assign them to class variables.
        String strTotalValue = intent.getExtras().getString("pass");
        dbTotalBillValue = Double.parseDouble(strTotalValue);
        blRouletteTip = intent.getExtras().getBoolean("blRouletteTip", false);
        blIncludeTip = intent.getExtras().getBoolean("blIncludeTip", false);
        
        //Grab the text view reserved to display the total bill amount and populate it. 
        TextView textview = (TextView) findViewById(R.id.totalValueS2);
        
        
        String formattedBuillValue = formatter.format(dbTotalBillValue);
        
        textview.setText("Total Value: " + formattedBuillValue); //TODO format currency correctly.
        
        editText = (EditText) findViewById(R.id.peopleAmountEdit);
        
        SeekBar tipPercentageBar = (SeekBar) findViewById(R.id.tipPercentageController);
        final TextView tipValueDetails = (TextView) findViewById(R.id.tipPercentageResult);
        
        if(blIncludeTip || blRouletteTip) { // user requested to add a tip so how tip scrollbar
	        tipPercentageBar.setMax(20);
	       
	        
	        tipPercentageBar.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
	        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
	        		// TODO Auto-generated method stub
	        		dbTipValue = (dbTotalBillValue/100) * progress;
	        		tipValueDetails.setText("Includes " + progress + "% tip of " + formatter.format(dbTipValue));
	        	}
	        	public void onStartTrackingTouch(SeekBar seekBar)
	        	{
	        		// TODO Auto-generated method stub
			    }
	        	public void onStopTrackingTouch(SeekBar seekBar){
	        		// TODO Auto-generated method stub
			    }
			});
	        
	        // End of setOnSeekBarChangeListener
        }
        else // hide tip scroll bar from user
        {
        	tipPercentageBar.setVisibility(View.INVISIBLE);
        	tipValueDetails.setVisibility(View.INVISIBLE);
        	final TextView tipMessage = (TextView) findViewById(R.id.strTipMessage);
        	tipMessage.setVisibility(View.INVISIBLE);
        }
        
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
    public void sendMessage(View view)
    {
    	System.out.println("Splitting...");
    	System.out.println(dbTotalBillValue+" Total value of the bill");
    	
    	String strNumberOfPeople = editText.getText().toString();
    	intNumberOfPeople = Integer.parseInt(strNumberOfPeople);
    	System.out.println("Number of People: " + intNumberOfPeople);
    	
    	Intent intent = new Intent(this, Output.class);
    	double dbAmountToSplit = dbTotalBillValue + dbTipValue;
        intent.putExtra("dbEachPay",split(dbAmountToSplit, intNumberOfPeople));
        intent.putExtra("dbAmountToSplit",dbAmountToSplit);
        intent.putExtra("intNumberOfPeople",intNumberOfPeople);
        intent.putExtra("dbTipValue",dbTipValue);
        
        
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
