package com.wenable.robotium.sample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.wenable.robotium.sample.activity.R;
/**
 * @author shashikanth
 * @version 1.0, June 2012
 */

public class LoginScreenActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private Intent mWelcomeIntent ;
	private Button mLoginBtn;
	private EditText mUserNameEt;
	private EditText mPasswordEt;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		init();
		setIdsToViews();
		setListnersToviews();


	}

	private void setListnersToviews() {
		mLoginBtn.setOnClickListener(this);
	}

	private void init() {
		mWelcomeIntent = new Intent(this, WelcomeActivity.class);
		mUserNameEt = (EditText)findViewById(R.id.usename_et);
		mPasswordEt = (EditText)findViewById(R.id.password_et);
	}

	private void setIdsToViews() {
		mLoginBtn = (Button)findViewById(R.id.login_btn);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.login_btn:
			if(mUserNameEt.getText().toString().equalsIgnoreCase("test")&& mPasswordEt.getText().toString().equalsIgnoreCase("test")){
				startActivity(mWelcomeIntent);
			}
			else Toast.makeText(this, "Wrong cred", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

}