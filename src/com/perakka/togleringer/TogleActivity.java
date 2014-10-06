package com.perakka.togleringer;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TogleActivity extends SherlockActivity {

	AudioManager am;
	ImageButton demo;
	boolean phoneSilent =true;
	static RelativeLayout mlayout; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_togle);
		am = (AudioManager)getSystemService(AUDIO_SERVICE);
		checkPhoneSilent();
		getActionBar().hide();
		toggleUI();
		ListenClick();
	}

	private void ListenClick() {
		// TODO Auto-generated method stub
		demo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(phoneSilent){
					am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
					
					phoneSilent = false;
					
					
				}
				else{
					am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					phoneSilent = true;
				}
				toggleUI();
			}
		});
	}

	private void toggleUI() {
		// TODO Auto-generated method stub
		mlayout = (RelativeLayout)findViewById(R.id.layoutid);
		demo = (ImageButton)findViewById(R.id.imageView1);
		Drawable newImage;
		if(phoneSilent){
			newImage = getResources().getDrawable(R.drawable.muted128);
			mlayout.setBackgroundColor(Color.parseColor("#C82300"));
		
		}
		else{
			newImage = getResources().getDrawable(R.drawable.sound);
			//
			mlayout.setBackgroundColor(Color.parseColor("#53B2FF"));
		}
		demo.setImageDrawable(newImage);
		
	}

	private void checkPhoneSilent() {
		// TODO Auto-generated method stub
		int ringer = am.getRingerMode();
		if(ringer == am.RINGER_MODE_SILENT){
			phoneSilent = true;
		}
		else if(ringer ==am.RINGER_MODE_VIBRATE){
			phoneSilent =true;
			
		}
		else{
			phoneSilent=false;
		}
	}

	
}
