package volley.scout.volleyscout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Set extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		Button gioc1=(Button)findViewById(R.id.button1);
		Intent i =getIntent();
		String pkg = getPackageName();
		if(i.getStringExtra(pkg+"numeromagliainserito")!=null){
			gioc1.setText(i.getStringExtra(pkg+"numeromagliainserito"));
			Intent openpage2=new Intent(Set.this,Tabella.class);
			startActivity(openpage2);
		}
		gioc1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent openPage = new Intent(Set.this,InserisciNumeroG.class);
				String pkg=getPackageName();
				Button butt=(Button)findViewById(R.id.button1);
				openPage.putExtra(pkg+"numerobottonepremuto", butt.getText().toString());
				startActivity(openPage);
			}
	    	
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}

}
