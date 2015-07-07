package com.wenable.robotium.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.wenable.robotium.sample.activity.R;

/**
 * @author shashikanth
 * @version 1.0, June 2012
 */
public class WelcomeActivity extends Activity {

	private String[] listOfMfg = {"Google", "Samsung", "Motorola", "HTC", };
	private ListView mMafgList ; 
	private TextView mTitleBarTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcomescreen);
		setIdsToViews();
		setUpUi();
		setAdaptersToViews();
		
	}

	private void setAdaptersToViews() {
		mMafgList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfMfg));
	}

	private void setUpUi() {
		mTitleBarTv.setText(getString(R.string.welcome_screen_text));
	}

	private void setIdsToViews() {
		mMafgList = (ListView)findViewById(R.id.mfg_list);
		mTitleBarTv = (TextView)findViewById(R.id.title_bar_title_tv);
	}
}
