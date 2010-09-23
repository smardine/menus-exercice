package de.vogella.android.listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
/*
 * A ListActivity extends Activity and simplifies the approach to show 
 * several objects in a list. It extends the standard Activity with a 
 * standard ListView Elements, callbacks for list events, e..g for 
 * selecting a list element and helper methods to access the current 
 * list position and the selected element(s).  */
 
public class MyList extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("projet listActivity","creation instance de l'application");
        String[] names = new String[] {"Napht�","Roeak","Iseut","Froyon","Osgart","Bethaeus","Norden"};
        //this.setListAdapter(new ArrayAdapter<String>(this, R.layout.rowlayout,R.id.label, names));
        this.setListAdapter(new MyArrayAdapter(this, names));
        } 
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	Log.i("projet listActivity","entree dans evenement clic");
    	Object o = this.getListAdapter().getItem(position);
    	String keyword = o.toString();
    	// afficher dans une petite boite de dialogue le choix �tabli (showinfo)
    	Toast.makeText(this, "Bravo! vous avez choisi "+ keyword, Toast.LENGTH_LONG).show();
    }
} 

