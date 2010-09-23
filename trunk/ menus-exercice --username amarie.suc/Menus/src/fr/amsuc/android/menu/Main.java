package fr.amsuc.android.menu;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends Activity implements OnLongClickListener {
    /** Called when the activity is first created. */
	LinearLayout view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //r�cup�rer la vue principale
        view = ((LinearLayout)this.findViewById(R.id.view1));
        //cr�er un �couteur de long clic
        view.setOnLongClickListener(this);
        //cr�er un �couteur pour la cr�ation du menu contextuel
        view.setOnCreateContextMenuListener(this);
        // comme les �couteurs sont affect�s � la vue �a signifie qu'il
        //est possible d'en customiser pour chacuen des vues.
    }
    private void onCreateMenu(Menu menu){
    	SubMenu m = menu.addSubMenu(0, 2000, 0, "sous menu 1");
    	m.setIcon(R.drawable.eqx_icon_green);
    	m.setHeaderIcon(android.R.drawable.ic_menu_agenda);
    	m.add(0, 1000, 0, "menu 1").setChecked(true).setCheckable(true);
    	m.add(0, 1001, 0, "menu 2").setEnabled(false);
    	//pourquoi sous-classer une m�thode ? = pour limiter les ressources
    	//privil�gier la cr�ation "� la demande" le menu est cr�� uniquement
    	//lorsque la touche physique <menu> est appuy�e par l'utilisateur
    	SubMenu r = menu.addSubMenu(0, 2001, 0, "sous menu 2");
    	r.setIcon(android.R.drawable.ic_menu_call); //icone systeme
    	
    	r.add(0, 1002, 0, "menu 3");
    	r.add(0, 1003, 0, "menu 4");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	onCreateMenu(menu);    	
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// �v�nement appel� lorsqu'un menu est choisi
    	switch(item.getItemId()) {
    	// l'identifiant integer est moins gourmand en ressource que le string
    	case 1000: 
    		Toast.makeText(this, "Menu 1", 1000).show();
    		break;
    	case 1001:
    		Toast.makeText(this, "Menu 2", 1000).show();
    		break;
    	case 1002:
    		Toast.makeText(this, "Menu 3", 1000).show();
    		break;
    	case 1003:
    		Toast.makeText(this, "Menu 4", 1000).show();
    		break;
    	}
    	Log.i("", ""+item.getTitle());
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	// C'est ici qu'on change les propri�t�s du menu 
    	// lorsque le menu s'ouvre. On peut donc ckecker ou pas un item
    	menu.findItem(2000).setTitle(""+SystemClock.elapsedRealtime());
    	// dans une activit� n�cessitant une authentifiction l'entr�e
    	// connexion peut dispara�tre si l'utilisateur est logg�.
    	return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onLongClick(View v) {
    	//si long clic alors appeler le menu contextuel
    	v.showContextMenu();
    	return false;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// cr�er "� la vol�e" le menu contextuel parce que le long clic
    	// demande son affichage
    	onCreateMenu(menu);    	    	
    	super.onCreateContextMenu(menu, v, menuInfo);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// ici r�agir lors du choix d'un item du menu contextuel
    	switch(item.getItemId()) {
    	// l'identifiant integer est moins gourmand en ressource que le string
    	case 1000: 
    		Toast.makeText(this, "Context Menu 1", 1000).show();
    		break;
    	case 1001:
    		Toast.makeText(this, "Context Menu 2", 1000).show();
    		break;
    	case 1002:
    		Toast.makeText(this, "Context Menu 3", 1000).show();
    		break;
    	case 1003:
    		Toast.makeText(this, "Context Menu 4", 1000).show();
    		break;
    	}
    	return super.onContextItemSelected(item);
    }
}