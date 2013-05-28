package com.example.gtacampus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class splash extends Activity{
	private Thread splashscreen;
	public Animation fade;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		fade = AnimationUtils.loadAnimation(this, R.anim.magfade);
		setContentView(R.layout.splashscr);
		findViewById(R.id.appimage).startAnimation(fade);
		splashscreen = new Thread() {
			@Override
			public void run()
			{
				try{
					synchronized(this){
						wait(3000);
					}
				}
				catch(Exception e){}
				finally{
				Intent startpt=new Intent(splash.this,CampusActivity.class);
				startActivity(startpt);
				finish();
				}
			}
			};
			splashscreen.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.menu, menu);
		return true;
	}
	
		
}