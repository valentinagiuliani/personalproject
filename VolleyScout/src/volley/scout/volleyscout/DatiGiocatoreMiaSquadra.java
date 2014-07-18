package volley.scout.volleyscout;

//import java.util.ArrayList;
//import java.util.List;

import java.util.List;

import helper.DatabaseHelper;
import model.BottoneMaglia;
//import model.BottoneMaglia;
import model.Giocatore;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DatiGiocatoreMiaSquadra extends Activity {
	DatabaseHelper db;
	String inserito;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dati_giocatore_mia_squadra);	
		
		Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener(){	
            public void onClick(View arg0) { 
            	
            	//verifico se devo apportare una modifica
            	db = new DatabaseHelper(getApplicationContext());
            	SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
            	Intent i =getIntent();
            	String pkg2=getPackageName();
            	System.out.println("*************+"+i.getStringExtra(pkg2+"numerobottone"));
            	
            	if(!db.getNumeroMaglia(i.getStringExtra(pkg2+"numerobottone")).equals("ERROR_NUM_NOT_FOUND")){
            		
//            		String nomeSchedaT = i.getStringExtra(pkg2+"nomeSchedaT");
//            		String cognomeSchedaT = i.getStringExtra(pkg2+"cognomeSchedaT");
//            		String ruoloSchedaT = i.getStringExtra(pkg2+"ruoloSchedaT");
//            		String numeroSchedaT = i.getStringExtra(pkg2+"numeroSchedaT");
            		String numeromaglia=db.getNumeroMaglia(i.getStringExtra(pkg2+"numerobottone"));
            		Giocatore p= db.getGiocatore(numeromaglia);
            		//Giocatore p = new Giocatore(nomeSchedaT,cognomeSchedaT,ruoloSchedaT,numeroSchedaT);
            		db.deleteGioc(p);	
            		
            		db.deletBot(i.getStringExtra((pkg2)+"numerobottone"));
            		List<BottoneMaglia> list=db.getAllBott();
          		  	for(BottoneMaglia b:list){
          			  System.out.println("********Lista dei bottoni e dei relativi giocatori");
          			  System.out.println(b.getNumeroMaglia());
          			  System.out.println(b.getNumeroBottone());
          		  }
            		
            	}
        		
            	//mi salvo i valori che ho preso in input
        		EditText nome=(EditText)findViewById(R.id.nome);    
        		String n=nome.getText().toString();	 
        		EditText cognome=(EditText)findViewById(R.id.cognome);
        		String c=cognome.getText().toString();        		 
        		EditText ruolo=(EditText)findViewById(R.id.ruolo);
        		String r=ruolo.getText().toString();        		 
        		EditText numero=(EditText)findViewById(R.id.numero);
        		String nu=numero.getText().toString();
        		 
        		  
        		if(!n.equals("") && !c.equals("") &&!r.equals("") && !nu.equals("")){ //se ho inserito correttamente i dati
        		  Giocatore g =new Giocatore(n,c,r,nu);
        		  db.insertGioc(g);  
        		  
        		  String butt = i.getStringExtra(pkg2+"numerobottone"); //prendo il testo del bottone che ho cliccato
        		  
        		  db.insertGiocBot(g,butt);
        		  
        		  //stampe di prova
        		  List<Giocatore> lista=db.getAllGioc();
        		  for(Giocatore h:lista){
        			  System.out.println("Lista dei giocatori inseriti");
        			  System.out.println(h.getNome());
        			  System.out.println(h.getCognome());
        			  System.out.println(h.getNumero());
        			  System.out.println(h.getRuolo());
        		  }
        		  
        		  List<BottoneMaglia> list=db.getAllBott();
        		  for(BottoneMaglia b:list){
        			  System.out.println("Lista dei bottoni e dei relativi giocatori");
        			  System.out.println(b.getNumeroMaglia());
        			  System.out.println(b.getNumeroBottone());
        		  }
        		  
        		  //passo all'activity successiva nome cognome ruolo numero e bottone
        		  Intent openPage2 = new Intent(DatiGiocatoreMiaSquadra.this,SchedaTecnica.class);
        		  String pkg=getPackageName();
        		  openPage2.putExtra(pkg+"nome",n);
        		  openPage2.putExtra(pkg+"cognome",c);
        		  openPage2.putExtra(pkg+"ruolo",r);
        		  openPage2.putExtra(pkg+"numero",nu);
        		  openPage2.putExtra(pkg+"numerobottone",butt);
        		  startActivity(openPage2);  
        		}   
        		else{ // se non ho inserito bene i campi
            	Intent openPage1 = new Intent(DatiGiocatoreMiaSquadra.this,Errore.class);
                startActivity(openPage1);  
                }
            }        
        
        });
        
        Button indietro = (Button)findViewById(R.id.indietro);
        indietro.setOnClickListener(new OnClickListener(){
        	@Override  
            public void onClick(View arg0) {  
        		  Intent openPage1 = new Intent(DatiGiocatoreMiaSquadra.this,MiaSquadra.class);    
                  startActivity(openPage1);  
            }   
        });
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dati_giocatore_mia_squadra, menu);
		return true;
	}

}
