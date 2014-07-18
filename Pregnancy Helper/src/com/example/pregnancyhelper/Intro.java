package com.example.pregnancyhelper;

import helper.DatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Intro extends Activity implements Runnable{
	DatabaseHelper db;
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // remove status bar
		db = new DatabaseHelper(getApplicationContext());	
		SQLiteDatabase s = db.getWritableDatabase();
		//db.onCreate(s);
		db.onOpen(s);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		Handler h = new Handler();
		h.postDelayed((Runnable) this,2000);
	}
	
	@Override
	public void run(){
	    Intent intent = new Intent(this, Home.class);
	    startActivityForResult(intent, 100);
	   }
	
	//si attiva nel caso in cui ho premuto indietro per uscire dall'app
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == RESULT_OK) {
	        setResult(RESULT_OK);
	        finish();
	    }
	}
}
