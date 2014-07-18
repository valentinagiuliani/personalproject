package com.example.pregnancyhelper;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
public class Settings extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // remove title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // remove status bar
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		Typeface tf = Typeface.createFromAsset(getAssets(),"font/Capriola-Regular.ttf");
		TextView header = (TextView) findViewById(R.id.header);
		header.setTypeface(tf);
	}
}
