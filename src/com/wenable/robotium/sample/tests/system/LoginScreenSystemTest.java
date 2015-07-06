package com.wenable.robotium.sample.tests.system;

import java.util.List;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.wenable.robotium.sample.activity.LoginScreenActivity;
import com.wenable.robotium.sample.activity.R;
import com.wenable.robotium.sample.activity.WelcomeActivity;
import com.wenable.robotium.sample.tests.AbstractnstrumentationTestCaseActivity;
import com.robotium.solo.Solo;

/**
 * @author shashikanth
 * @version 1.0, June 2012
 */
@SuppressWarnings("rawtypes")
public class LoginScreenSystemTest extends AbstractnstrumentationTestCaseActivity{

	private static final String TARGET_PACKAGE_ID = "com.wenable.robotium.sample.activity";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = LoginScreenActivity.class.getName();
	private Solo mSolo;

	@SuppressWarnings("unchecked")
	public LoginScreenSystemTest() throws ClassNotFoundException {
		super(TARGET_PACKAGE_ID, Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME));
	}

	@Override
	protected void setUp() throws Exception {
		mSolo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCanNavigateToWelComeScreen()  {
		Button loginButton = (Button)mSolo.getCurrentActivity().findViewById(R.id.login_btn);
		EditText userNameEt = (EditText)mSolo.getCurrentActivity().findViewById(R.id.usename_et);
		EditText passwordEt = (EditText)mSolo.getCurrentActivity().findViewById(R.id.password_et);
		mSolo.enterText(userNameEt, "test");
		mSolo.enterText(passwordEt, "check");
		mSolo.clickOnView(loginButton);		
		mSolo.sleep(2000);
		mSolo.waitForActivity(WelcomeActivity.class.getName());   // Waiting for the Loginscreen, by default it waits 2000ms 
		String currentActivity = mSolo.getCurrentActivity().getLocalClassName();		
		// else returns false
		if (currentActivity.equalsIgnoreCase("WelcomeActivity")) {
			assertTrue(true);
		}else assertFalse(true);
	}//End of testCanNavigateToWelComeScreen()

	
	public void testCanClickOnItem(){
		Button loginButton = (Button)mSolo.getCurrentActivity().findViewById(R.id.login_btn);
		EditText userNameEt = (EditText)mSolo.getCurrentActivity().findViewById(R.id.usename_et);
		EditText passwordEt = (EditText)mSolo.getCurrentActivity().findViewById(R.id.password_et);
		mSolo.enterText(userNameEt, "test");
		mSolo.enterText(passwordEt, "test");
		mSolo.clickOnView(loginButton);		
		mSolo.sleep(2000);
		mSolo.waitForActivity(WelcomeActivity.class.getName());   // Waiting for the Loginscreen, by default it waits 2000ms 
		String currentActivity = mSolo.getCurrentActivity().getLocalClassName();		
		List<ListView> listOfListViews = mSolo.getCurrentViews(ListView.class);
		ListView mfgListView = listOfListViews.get(0);
		System.out.println("Number of lists in screen"+listOfListViews.size());
		System.out.println("Number items in List"+mfgListView.getCount());
		int listSize = mfgListView.getAdapter().getCount();
		for (int i = 1; i <= listSize; i++) {
			mSolo.clickInList(i);
		}
	}

	public void tearDown() throws Exception {
		try {
			soloFinalize(mSolo);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
}
