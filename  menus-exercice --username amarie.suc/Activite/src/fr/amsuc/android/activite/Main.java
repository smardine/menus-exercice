package fr.amsuc.android.activite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity implements OnClickListener {
	
	Button button;
	EditText edit;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = ((Button)this.findViewById(R.id.bouton1));
        edit = ((EditText)this.findViewById(R.id.edit1));
        button.setOnClickListener(this);
        Log.i("mon activite", "OnCreate");
        
        if (this.getIntent().getExtras() != null){
        	String s=this.getIntent().getExtras().getString("madonnee");
        	Log.i("sous activite", "OnCreate r�cupere "+s);
        	edit.setText(s);
        }
        this.setResult(2000);
    }
    @Override
    protected void onStart() {
    	Log.i("mon activite", "onstart :"+this.getIntent().toString());
    	super.onStart();
    }
    
    
    @Override
    protected void onPause() {
    	Log.i("monactivite", "On Pause");
    	super.onPause();
    }
    
    @Override
    protected void onResume() {
    	Log.i("mon activite", "On Resume");
    	super.onResume();
    }
    
    @Override
    protected void onStop() {
    	Log.i("mon activite", "OnStop");
    	super.onStop();
    }
    
    @Override
    protected void onDestroy() {
    	Log.i("mon activite", "OnDestroy");
    	super.onDestroy();
    }
	@Override
	public void onClick(View arg0) {
		// ici on peut pousser une nouvelle activit� grace aux Intent
		
		//cr�ation d'une instance de Main2:
		Intent intent = new Intent(this, Main2.class); 
		intent.putExtra("madonnee", "J'envoi Bonjour! depuis activite main");
		
		// pour d�marrer cette nouvelle instance:
		this.startActivityForResult(intent, 1000); 
		//??le requestcode (2eme arg) est un param�tre qu'on veut envoyer � son sous-actvit� ??
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//sert � r�cup�rer un �ventuel resultcode �mis par l'activit�
		//que cette activit� � lancer
		Log.i("", "main1.requestcode:"+requestCode+" main1.resultcode:"+resultCode);
		super.onActivityResult(requestCode, resultCode, data);
	}
}