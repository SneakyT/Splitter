package com.example.first;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Third extends Activity {
	
	//double splitvalue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        
        Intent intent = getIntent();
        Double splitValue = intent.getExtras().getDouble("pass2");
        System.out.println("asdfek "+splitValue);
        //splitvalue = Double.parseDouble(strSplitValue);
        
        TextView textview = (TextView) findViewById(R.id.totalValueS3);
        
        textview.setText("The amount you each need to pay is: \n £"+splitValue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_third, menu);
        return true;
    }
}
