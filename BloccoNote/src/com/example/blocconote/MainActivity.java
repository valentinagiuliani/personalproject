package com.example.blocconote;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("mamma");
		super.onCreate(savedInstanceState);
		System.out.println("mamma2");
		setContentView(R.layout.activity_main);
		System.out.println("mamma3");
		Button nuova=(Button)findViewById(R.id.nuova_nota);
		System.out.println(nuova==null);
		nuova.setOnClickListener(new OnClickListener(){
			public void onClick(View agr0){
				Intent openPage1 = new Intent(MainActivity.this,NuovaNota.class);
				startActivity(openPage1);
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
