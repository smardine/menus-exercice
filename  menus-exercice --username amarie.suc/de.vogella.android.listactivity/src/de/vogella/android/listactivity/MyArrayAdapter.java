package de.vogella.android.listactivity;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * surcharger la m�thode d'affichage d'une ligne de liste
 * de mani�re � customiser par exemple l'icone en fonction de la ligne
 * en cours d'affichage
 */
public class MyArrayAdapter extends ArrayAdapter<String>{
	
	private final Activity context;
	private final String[] names;
	
	public MyArrayAdapter(Activity context, String[] names){
		super(context, R.layout.rowlayout, names);
		this.context = context;
		this.names = names;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.rowlayout, null, true);
		
		TextView label = (TextView) rowView.findViewById(R.id.label);
		label.setText(names[position]);
		traceInfo("dessin de "+names[position]);
		
		if ( names[position].startsWith("Iseut") || names[position].startsWith("Osgart")) {
			ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
			imageView.setImageResource(R.drawable.eqx_icon_red);
		}
		return rowView;
		
	}

	private void traceInfo(String string) {
		// TODO Auto-generated method stub
		Log.i("projet listactivity",string);
	}

}