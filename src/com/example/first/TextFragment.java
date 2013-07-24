package com.example.first;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
	
    private static TextView textview;
	
    @Override
    public View onCreateView(LayoutInflater inflater, 
              ViewGroup container, Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.text_fragment, 
                   container, false);
        

       // Grab the Intent object that was used to trigger this activity's launch.
       Intent intent = getActivity().getIntent();
       
       // Unpack values from intent
       double dbEachPay = intent.getExtras().getDouble("dbEachPay");
       double dbAmountToSplit = intent.getExtras().getDouble("dbAmountToSplit");
       double intNumberOfPeople = intent.getExtras().getInt("intNumberOfPeople");
       double dbTipValue = intent.getExtras().getDouble("dbTipValue");
       // TODO: intent also contains unhandled blRouletteTip data.
       
        textview = (TextView) view.findViewById(R.id.strTipMessage);
        textview.setText("Each pay: "+ dbEachPay +"\nAmount to split: "+ dbAmountToSplit +
        		"\nNumber of people: "+ intNumberOfPeople +"\nTip value: "+ dbTipValue +"");
        
        return view;
    }
    
}