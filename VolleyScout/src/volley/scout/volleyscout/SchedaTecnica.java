package volley.scout.volleyscout;

import model.Giocatore;
import helper.DatabaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SchedaTecnica extends Activity {
	DatabaseHelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scheda_tecnica);
		db = new DatabaseHelper(this);	
		SQLiteDatabase s = db.getWritableDatabase();
		db.onOpen(s);
		Intent i =getIntent();
		String pkg=getPackageName();
		String numerobottone = i.getStringExtra(pkg+"numerobottone");
		String numeromaglia=db.getNumeroMaglia(numerobottone);
		Giocatore g =db.getGiocatore(numeromaglia);
		TextView tv =(TextView)findViewById(R.id.result);			
		
		tv.append(g.getNome() + " " + g.getCognome() + " " + g.getRuolo() +" "+ g.getNumero());
		
		Button indietro=(Button)findViewById(R.id.tasto_indietro);
        indietro.setOnClickListener(new OnClickListener(){
        	@Override  
            public void onClick(View arg0) {
        		  Intent j =getIntent();
        		  db = new DatabaseHelper(getApplicationContext());	
        		  SQLiteDatabase s = db.getWritableDatabase();
        		  db.onOpen(s);
        		  Intent openPage1 = new Intent(SchedaTecnica.this,MiaSquadra.class);  //torno alla mia squadra
        		  String pkg=getPackageName();
        		  String cognomeIndietro = j.getStringExtra(pkg+"cognome");
        		 // String bottone = j.getStringExtra(pkg+"bottone");
        		  openPage1.putExtra(pkg+"cognomeIndietro",cognomeIndietro);
                  startActivity(openPage1);  
            }   
        });
        
        Button modifica=(Button)findViewById(R.id.modifica);
        modifica.setOnClickListener(new OnClickListener(){
        	@Override  
            public void onClick(View arg0) {
        			Intent j=getIntent();
        			String pkg=getPackageName();
        			Intent openPage2 = new Intent(SchedaTecnica.this,DatiGiocatoreMiaSquadra.class);  //torno alla mia squadra
        			openPage2.putExtra(pkg+"numerobottone",j.getStringExtra(pkg+"numerobottone"));    			  
        			startActivity(openPage2);  
            }   
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scheda_tecnica, menu);
		return true;
	}

}
