package com.shaikhhamadali.blogspot.com.ringermode;

import com.shaikhhamadali.blogspot.com.ringermode.R;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	ImageButton vibrate,silent,normal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 vibrate = (ImageButton) findViewById(R.id.vibrate);
		 silent = (ImageButton) findViewById(R.id.silent);
		 normal = (ImageButton) findViewById(R.id.normal);
		
		final AudioManager audioManager = 
				(AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);

		vibrate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				resetUI(1);
				Toast.makeText(getBaseContext(), "Mode: Vibration ", Toast.LENGTH_SHORT).show();
			}
		});
		
		silent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				resetUI(2);
				Toast.makeText(getBaseContext(), "Mode: Silent ", Toast.LENGTH_SHORT).show();
			}
		});
		
		normal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				resetUI(3);
				Toast.makeText(getBaseContext(), "Mode: Ringing ", Toast.LENGTH_SHORT).show();
			}
		});
		
		
	}

	private void resetUI(int i) {
		if(i==1)vibrate.setImageResource(R.drawable.vibrate);
		else vibrate.setImageResource(R.drawable.vibrate_black);
		if(i==2)silent.setImageResource(R.drawable.mute);
		else silent.setImageResource(R.drawable.mute_black);
		if(i==3)normal.setImageResource(R.drawable.sound_color);
		else normal.setImageResource(R.drawable.sound_black);
	}
}
