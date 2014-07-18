package volley.scout.volleyscout;

import model.BottoneMaglia;
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

public class MainActivity extends Activity {
	DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button1);
        Button partita = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener(){
        	@Override  
            public void onClick(View arg0) {  
        		  Intent openPage1 = new Intent(MainActivity.this,MiaSquadra.class);    
        		  db = new DatabaseHelper(getApplicationContext());	
          			SQLiteDatabase s = db.getWritableDatabase();
          			db.onOpen(s);
          			//db.delete();
          			
          			for(BottoneMaglia t:db.getAllBott()){
        			  	System.out.println("Righe della tabella dei bottoni");
        		  		System.out.println("numeromaglia "+t.getNumeroMaglia());
        		  		System.out.println("numerobottone "+t.getNumeroBottone());
        		  }
          			
          			for(Giocatore g: db.getAllGioc()){
        			  	System.out.println("Righe della tabella dei giocatori");
        		  		System.out.println(g.getCognome());
        		  		System.out.println(g.getNome());
        		  		System.out.println(g.getRuolo());
        		  		System.out.println(g.getNumero());
        		  		
        		  }
        		  
          			
                  startActivity(openPage1);  
            }   
        });
        
        partita.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openPage = new Intent(MainActivity.this,SceltaSuPartite.class);
				startActivity(openPage);
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
