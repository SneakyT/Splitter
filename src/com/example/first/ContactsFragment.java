package com.example.first;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// TODO these site potentially have the answer for this class
//http://www.vogella.com/articles/AndroidListView/article.html#listfragments
//http://nickcharlton.net/posts/building-custom-android-listviews.html

/**
 * 
 * Contacts Fragment
 * 
 * @author mikey
 *
 */
public class ContactsFragment extends ListFragment {

	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    String[] values = new String[] { "Tits", "Boobs", "Breasts",
	            "Jugs", "Melons", "Hooters", "Knockers", "Twins",
	            "Traffic stoppers", "Headlights" }; // I may or may not be drunk right now.
	    
	    //Using a default android layout here. Pretty bad ass, but looks ugly as fuck.
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter); // It looks like you have to use adapter's to populate List views.
	    //TODO change this to a basic fragment and define a list view in it's layout for more flexibility.
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		System.out.println("amazement!");
	}

}

