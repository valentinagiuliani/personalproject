package volley.scout.volleyscout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Errore extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_errore);
		Button button=(Button)findViewById(R.id.indietro);
        button.setOnClickListener(new OnClickListener(){
        	@Override  
            public void onClick(View arg0) {  
        		  Intent openPage1 = new Intent(Errore.this,DatiGiocatoreMiaSquadra.class);    
                  startActivity(openPage1);  
            }   
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.errore, menu);
		return true;
	}

}
