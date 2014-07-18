package volley.scout.volleyscout;

import java.util.ArrayList;
import java.util.List;



import model.BottoneMaglia;
import helper.DatabaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MiaSquadra extends Activity {
	DatabaseHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mia_squadra);
		
		Button button=(Button)findViewById(R.id.button1);
		Button button2=(Button)findViewById(R.id.button2);
		Button button3=(Button)findViewById(R.id.button3);
		Button button4=(Button)findViewById(R.id.button4);
		Button button5=(Button)findViewById(R.id.button5);
		Button button6=(Button)findViewById(R.id.button6);
		Button button7=(Button)findViewById(R.id.button7);
		Button button8=(Button)findViewById(R.id.button8);
		Button button9=(Button)findViewById(R.id.button9);
		Button button10=(Button)findViewById(R.id.button10);
		Button button11=(Button)findViewById(R.id.button11);
		Button button12=(Button)findViewById(R.id.button12);
		Button button13=(Button)findViewById(R.id.button13);
		Button home =(Button) findViewById(R.id.home);
		List<BottoneMaglia> lis = new ArrayList<BottoneMaglia>();
		db = new DatabaseHelper(getApplicationContext());	
		SQLiteDatabase s = db.getWritableDatabase();
		db.onOpen(s);
		lis= db.getAllBott();
		//String pkg2=getPackageName();
		for(BottoneMaglia y : lis){
			if(y.getNumeroBottone().equals("Giocatore1")) //se è presente vado alla scheda tecnica
				button.setText(y.getNumeroMaglia());	
			if(y.getNumeroBottone().equals("Giocatore2")) //se è presente vado alla scheda tecnica
				button2.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore3")) //se è presente vado alla scheda tecnica
				button3.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore4")) //se è presente vado alla scheda tecnica
				button4.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore5")) //se è presente vado alla scheda tecnica
				button5.setText(y.getNumeroMaglia());	
			if(y.getNumeroBottone().equals("Giocatore6")) //se è presente vado alla scheda tecnica
				button6.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore7")) //se è presente vado alla scheda tecnica
				button7.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore8")) //se è presente vado alla scheda tecnica
				button8.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore9")) //se è presente vado alla scheda tecnica
				button9.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore10")) //se è presente vado alla scheda tecnica
				button10.setText(y.getNumeroMaglia());	
			if(y.getNumeroBottone().equals("Giocatore11")) //se è presente vado alla scheda tecnica
				button11.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore12")) //se è presente vado alla scheda tecnica
				button12.setText(y.getNumeroMaglia());
			if(y.getNumeroBottone().equals("Giocatore13")) //se è presente vado alla scheda tecnica
				button13.setText(y.getNumeroMaglia());
		}
		
		//se clicco sul primo bottone
		button.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
            	String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button1);        		
        		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore1")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore1");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore1");
        			startActivity(openPage1);
        		}
        	}   
        });
        
		button2.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button2);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore2")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore2");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore2");
        			startActivity(openPage1);
        		}
        	}   	
		});
		
        button3.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button3);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore3")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore3");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore3");
        			startActivity(openPage1);
        		}
        	}   	
		});
        button4.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button4);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore4")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore4");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore4");
        			startActivity(openPage1);
        		}
        	}   	
		});
        
        button5.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button2);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore5")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore5");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore5");
        			startActivity(openPage1);
        		}
        	}   	
		});
       
        button6.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button6);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore6")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore6");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore6");
        			startActivity(openPage1);
        		}
        	}   	
		});
        
        button7.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button7);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore7")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore7");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore7");
        			startActivity(openPage1);
        		}
        	}   	
		});
        button8.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button8);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore8")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore8");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore8");
        			startActivity(openPage1);
        		}
        	}   	
		});
        button9.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button9);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore9")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore9");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore9");
        			startActivity(openPage1);
        		}
        	}   	
		});
        button10.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button10);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore10")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore10");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore10");
        			startActivity(openPage1);
        		}
        	}   	
		});
        
        button11.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button11);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore11")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore11");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore11");
        			startActivity(openPage1);
        		}
        	}   	
		});
        
        button12.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button12);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore12")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore12");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore12");
        			startActivity(openPage1);
        		}
        	}   	
		});
        button13.setOnClickListener(new OnClickListener(){
        	@Override  
        	public void onClick(View arg0) { 
        		db = new DatabaseHelper(getApplicationContext());	
        		SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg=getPackageName();
        		Intent openPage1 = new Intent(MiaSquadra.this,DatiGiocatoreMiaSquadra.class);  
        		Intent openPage2 = new Intent(MiaSquadra.this,SchedaTecnica.class);   		
        		Button bu=(Button)findViewById(R.id.button13);        		
    		
        		//mi calcolo la lista dei bottoni salvati
        		List<BottoneMaglia> l = new ArrayList<BottoneMaglia>();
        		l= db.getAllBott();   
        		boolean trovato =false;
        		//verifico che il bottone che ho cliccato sia presente nella lista
        		for(BottoneMaglia b : l){
        			if(b.getNumeroBottone().equals("Giocatore13")) //se è presente vado alla scheda tecnica
        				trovato=true;		
        		}
        		if(trovato){
        			openPage2.putExtra(pkg+"numerobottone", "Giocatore13");
        			startActivity(openPage2);
        		}else{
        			//se non è presente nel database allora puoi inserire il giocatore
        			openPage1.putExtra(pkg+"numerobottone", "Giocatore13");
        			startActivity(openPage1);
        		}
        	}   	
		});
        
        home.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
        		Intent openpage3 = new Intent(MiaSquadra.this,MainActivity.class); 
        		startActivity(openpage3);
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mia_squadra, menu);
		return true;
	}

}
