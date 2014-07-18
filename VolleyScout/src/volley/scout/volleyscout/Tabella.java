package volley.scout.volleyscout;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;


public class Tabella extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabella);
		GridView gridview = (GridView) this.findViewById(R.id.gridview);
		String[] dati = new String[]{ 
				"uno","due","tre","quattro","cinque",
				"sei","sette","otto","nove","dieci"
		};
		ListAdapter adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1, 
				dati
			);
		gridview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabella, menu);
		return true;
	}

}
