//----------------ROBOTIUM STEPS TO SETUP--------------------//

* First step you need add the JUNIT library to your project for that goto properties of the project select Libraries tab and select jUnit say JUnit next you will find one drop down box select JUnit4
* Next download the ronotium jar from (http://code.google.com/p/robotium/) web site add the jar to your project (If you don't have a libs folder in your project create one in project directory and paste the robo jar into libs, add the library into classpath as well)
* All the system test cases has to go in respective package (in MAF com.customername.appname.test.system)
* You can find the Root package name in AndroidManifestfile (android:packagename="rootpackagename")
* Every SystemTest class has to extend the AbstractnstrumentationTestCaseActivity
  Note : Please don't change any thing in Abstract class if you want to change anything please concern respective technical person or author.
* Add the the use-library and Instrumentation elements in AndroidManifest. If you don't add them you can not run your test.
		Ex :  <uses-library android:name="android.test.runner" /> (In application element)
			   <instrumentation
        			android:name="android.test.InstrumentationTestRunner"
        			android:targetPackage="com.packagename.root" />
        			
** Thats all you need to do then you can start writing your testcases
* After Running the test case you see your result in JUnit console, if the jUnit view is not configured in your eclipse you can add from from fast view
* If you want to run the all the tests in the package you can run them using launch configuration.
 


Some key points while writing the testcases          				
* Every test case should be independent
* Each test case represent only that functionality should not do more than that
* Try to avoid wait() or sleep()
* Don't use static values while operating the views, get the views and do operations on them 
         Ex : If you have a List view, test case is to click on each item you should not do that click on each index, 
              you should get the size of the list and click on each item.
              
