package com.wenable.robotium.sample.tests;

import org.junit.BeforeClass;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * @author shashikanth
 * @param <T>
 * 
 */
public abstract class AbstractnstrumentationTestCaseActivity<T extends Activity> extends ActivityInstrumentationTestCase2<T> {
	public final static String rootPackageName = "com.wenable.robotium.sample.activity";
	
	@BeforeClass
	public static void setup(){
		
	}
	
	public AbstractnstrumentationTestCaseActivity(String pkg, Class<T> activityClass) {
		super(pkg, activityClass);
	}
	
	public void soloFinalize(Solo solo){
		try {
			solo.finishOpenedActivities();
			solo.finalize();
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
