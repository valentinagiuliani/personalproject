package volley.scout.volleyscout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GiocatoreNonPresente extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_giocatore_non_presente);
		
		//GESTIRE I PULSANTI !!!!!!!!!!!!!!!!
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.giocatore_non_presente, menu);
		return true;
	}

}
