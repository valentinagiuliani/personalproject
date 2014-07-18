package com.example.pregnancyhelper;

import helper.DatabaseHelper;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity {
	DatabaseHelper db;
	CharSequence[] items = { "Imposta la data dell'ultima mestruazione nei settings" };
	boolean[] itemsChecked = new boolean [items.length];
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // remove status bar
		db = new DatabaseHelper(getApplicationContext());
		//SQLiteDatabase s = db.getWritableDatabase();
		//db.onOpen(s);
		if(db.getDate() == null ){
					// custom dialog
					final Dialog dialog = new Dialog(context,R.style.FullHeightDialog); //ho creato uno style nuovo che elimina il titolo
					dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); // sfondo dtrasparente del dialog
					dialog.setContentView(R.layout.custom);
					dialog.show();
					((TextView)dialog.findViewById(R.id.benvenuta)).setTypeface(Typeface.createFromAsset(getAssets(), "font/Raleway-SemiBold.otf"));
					((TextView)dialog.findViewById(R.id.textView2)).setTypeface(Typeface.createFromAsset(getAssets(), "font/Raleway-SemiBold.otf"));
					((Button)dialog.findViewById(R.id.nograzie)).setTypeface(Typeface.createFromAsset(getAssets(), "font/Raleway-SemiBold.otf"));
					((Button)dialog.findViewById(R.id.ok)).setTypeface(Typeface.createFromAsset(getAssets(), "font/Raleway-SemiBold.otf"));
					
					((Button)dialog.findViewById(R.id.ok)).setOnClickListener(new OnClickListener(){
						public void onClick(View agr0){
							Intent settings = new Intent(Home.this,Settings.class);
							startActivity(settings);
						}
					});
					
			
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Typeface tf = Typeface.createFromAsset(getAssets(),"font/Raleway-SemiBold.otf");
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		Button button4 = (Button) findViewById(R.id.button4);
		
        button1.setTypeface(tf);       
        button2.setTypeface(tf);   
        button3.setTypeface(tf);
        button4.setTypeface(tf);
        
        
	}
	
	@Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Sei sicura di voler uscire?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "si", then he is allowed to exit from application
            	setResult(RESULT_OK);
            	finish();
            }
        });
        builder.setNegativeButton("No grazie",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }    

	
}
