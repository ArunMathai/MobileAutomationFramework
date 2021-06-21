package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RegistrationPage extends BasePage {


	TestUtils utils = new TestUtils();

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/progressBtn") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='Register']")
	private MobileElement btnRegister;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/progressBtn") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private MobileElement btnContinue;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/yesOption") 
	@iOSXCUITFindBy (id = "Yes")
	private MobileElement checkBoxYesOption;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/noOption") 
	@iOSXCUITFindBy (id = "No")
	private MobileElement checkBoxNoOption;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/editTextView") 
	@iOSXCUITFindBy (id = "Repeat email address")
	private MobileElement editBoxEmailId;

	//Accept web element for Android
	By acceptWebElementAndroid=By.id("onetrust-accept-btn-handler");

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/editTextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField")
	private MobileElement editBoxCardNumber;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/errorText") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Nectar card number must have 11 numbers']")
	private MobileElement errorTextWrongCardNumber;

	@AndroidFindBy (xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[2]") 
	@iOSXCUITFindBy (id = "Accept and continue")
	private MobileElement acceptContinueBtn;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/title") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Nectar card number must have 11 numbers']")
	private MobileElement checkEmailTitle;

	@AndroidFindBy (accessibility = "Accept and continue")
	@iOSXCUITFindBy (id = "Accept and continue")
	private MobileElement acceptContinueCookieForEmulator;

	GlobalParams params = new GlobalParams();


	public RegistrationPage(){
	}


	public RegistrationPage clickYesOrNoOptionForHavingNectarCard(String haveNectarcard) {
		if(haveNectarcard.equals("Yes")) {
			click(checkBoxYesOption, "User clicks Yes checkbox as he is having Nectar card");
		}
		else {
			click(checkBoxNoOption, "User clicks No checkbox as he dont have Nectar card");
		}
		return this;
	}

	public RegistrationPage clickContinueButton() {
		click(btnContinue, "Click continue button");
		return this;
	}

	public RegistrationPage enterEmailId(String emailId) throws InterruptedException {
		clear(editBoxEmailId);	
		sendKeys(editBoxEmailId, emailId, "login with " + emailId);
		return this;
	}
	public RegistrationPage validateErrorMessage(String errorMessage)  {
		String errorMsg=getText(errorTextWrongCardNumber, "error message after entering wrong card Number");
		System.out.println("locator error Messgae "+errorMsg);
		System.out.println("error message from BDD "+errorMessage);

		Assert.assertEquals(errorMsg, errorMessage);

		return this;
	}

}
