package com.example.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Second extends Activity {
	
	double totalvalue;
	int numberOfPeople;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        Intent intent = getIntent();
        String strTotalValue = intent.getExtras().getString("pass");
        
        totalvalue = Double.parseDouble(strTotalValue);
        
        TextView textview = (TextView) findViewById(R.id.totalValueS2);
        
        textview.setText("Total Value: £"+totalvalue);
        
        EditText editText = (EditText) findViewById(R.id.totalBillS1);     
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_second, menu);
        return true;
    }
    
    
    public void sendMessage2(View view)
    {
    	System.out.println("Splitting...");
    	System.out.println(totalvalue+" Total value of the bill");
    	
    	EditText editText = (EditText) findViewById(R.id.peopleAmountEdit);
    	String strNumberOfPeople = editText.getText().toString();
    	numberOfPeople = Integer.parseInt(strNumberOfPeople);
    	
    	System.out.println(numberOfPeople+" Number of People");
    	
        Intent intent = new Intent(this, Third.class);
        intent.putExtra("pass2",split(totalvalue,numberOfPeople));
        System.out.println("asdf "+split(totalvalue,numberOfPeople));
        startActivity(intent);
    }
    
    public double split(double bill, int people)
    {
		double output = bill/people;
    	return output;
    	
    }
    	
}
