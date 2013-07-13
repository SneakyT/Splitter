package com.example.first;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class Output extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_third, 
               menu);
		return true;
	}
	
}





/*import java.text.NumberFormat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TextView;

public class Output extends FragmentActivity {
	
	//double splitvalue;

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        
        Intent intent = getIntent();
        Double splitValue = intent.getExtras().getDouble("pass2");
        System.out.println("Final amount "+splitValue);
        
        TextView textview = (TextView) findViewById(R.id.totalValueS3);
        
        // Format double to currency TODO Ensure locale settings work for currency.
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String formattedSplitValue = formatter.format(splitValue);
        
        textview.setText("The amount you each need to pay is: \n" + formattedSplitValue);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("asdasdasd");
        setContentView(R.layout.activity_output);
        
        System.out.println("Working ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_third, menu);
        return true;
    }
}*/
