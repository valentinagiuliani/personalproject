package volley.scout.volleyscout;

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
import android.widget.EditText;

public class InserisciNumeroG extends Activity {
	DatabaseHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inserisci_numero_g);
		Button ok=(Button)findViewById(R.id.ok);
		ok.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openPage = new Intent(InserisciNumeroG.this,Set.class);
				db = new DatabaseHelper(getApplicationContext());
            	SQLiteDatabase s = db.getWritableDatabase();
        		db.onOpen(s);
        		String pkg =getPackageName();
				EditText numero=(EditText)findViewById(R.id.editText1);
				String numeroinserito =numero.getText().toString();
				List<BottoneMaglia> lista = db.getAllBott();
				int trovato =0;
				if(!numeroinserito.equals("")){ //se ho inserito un numero corretto
					for(BottoneMaglia b:lista)
						if(b.getNumeroMaglia().equals(numeroinserito)){ //se il numero è presente nel database
							openPage.putExtra(pkg+"numeromagliainserito",numeroinserito);
							trovato=1; //imposto trovfato a 1 se trovo il valore nel database
						}
					
				}else {
					openPage =new Intent(InserisciNumeroG.this,Errore.class);
				}
				
				if(trovato==0)// se non è presente nel database
						openPage=new Intent(InserisciNumeroG.this,GiocatoreNonPresente.class);
				startActivity(openPage);
			}
	    	
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inserisci_numero_g, menu);
		return true;
	}

}
