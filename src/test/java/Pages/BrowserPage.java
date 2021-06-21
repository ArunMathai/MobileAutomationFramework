package Pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BrowserPage extends BasePage {
	TestUtils utils = new TestUtils();
	@AndroidFindBy (accessibility = "test-Username") 
	@iOSXCUITFindBy (id = "test-Username")
	private MobileElement usernameTxtFld;

	
	
	public BrowserPage openBrowser(String emailId) {

		DriverManager dm=new DriverManager();

		changeDriverContext("WEBVIEW");
		
		
		
	//	((AndroidDriver)dm.getDriver()).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		((AndroidDriver)dm.getDriver()).startActivity(new Activity(
				"com.android.chrome", "com.google.android.apps.chrome.Main"));
		
		((AndroidDriver)dm.getDriver()).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	((AndroidDriver) dm.getDriver()).startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main")); 		
		((AndroidDriver)dm.getDriver()).get("https://facebook.com/en/");
		WebElement div =((AndroidDriver) dm.getDriver()).findElement(By.id("login"));
		//div.sendKeys(emailId);
	
		
		//Assert.assertEquals("I am a div", div.getText()); //check the text retrieved matches expected value

		
//		dm.startActivity(new Activity("chrome_app_package", "chrome_app_activity")); 
//		dm.getDriver().get("your_url"); 
//		//dm.getDriver().pressKeyCode(AndroidKeyCode.BACK);
//
//		pkg = “com.android.chrome”;
//		activity = “com.google.android.apps.chrome.Main”;
//		?

		return this;
	}
}

