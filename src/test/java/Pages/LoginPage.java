package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();


	@AndroidFindBy (accessibility = "test-LOGIN") 
	@iOSXCUITFindBy (id = "test-LOGIN")
	private MobileElement loginBtn;

	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement errTxt;

	/////............................../////
	//@AndroidFindBy (accessibility = "onetrust-accept-btn-handler") 
	//@iOSXCUITFindBy (id = "")
	//private MobileElement btnAcceptContinue;



	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/progressBtn") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='Register']")
	private MobileElement btnRegister;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/progressBtn") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private MobileElement btnContinue;


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
	@iOSXCUITFindBy (id = "Let's check it's you")
	private MobileElement checkEmailTitle;

	@AndroidFindBy (accessibility = "Accept and continue")
	@iOSXCUITFindBy (id = "Accept and continue")
	private MobileElement acceptContinueCookieForEmulator;




	//..............Login scenarios Locators...................////////////
	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/existingUserButton") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='Log in']")
	private MobileElement btnLogin;

	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.widget.EditText") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name='Nectar Login']/XCUIElementTypeTextField")
	private MobileElement usernameTxtFld;

	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]/android.view.View[3]/android.view.View[2]/android.widget.EditText") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name='Nectar Login']/XCUIElementTypeSecureTextField")
	private MobileElement passwordTxtFld;

	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[2]")
	@iOSXCUITFindBy (id = "Accept All Cookies")
	private MobileElement acceptContinueCookieInLoginPage;



	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[3]/android.view.View[5]/android.widget.Button")
	@iOSXCUITFindBy (id = "Login")
	private MobileElement loginButtonInLoginPage;

	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Log in']")
	private MobileElement titleLoginPage;


	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/editTextView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name='NectarPreProd']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField")
	private MobileElement editBox2FA;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/progressBtn") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private MobileElement btnConfirmIn2FAPage;


	GlobalParams params = new GlobalParams();





	public LoginPage(){
	}

	public LoginPage acceptCookies() {

		//waitForVisibility(btnLogin);

		if(params.getPlatformName().equals("Android"))
		{		
			//			waitForVisibility(acceptContinueBtn);
			//			click(acceptContinueBtn, "User clicks Accept and continue button for accepting cookie");	
			//			boolean val=find(acceptContinueBtn, 5);
			//			if(val) {
			//				click(acceptContinueBtn, "User clicks Accept and continue button for accepting cookie");
			//			}
			//			else {
			//				utils.log().info("No cookie Popup is present");
			//			}
			//	

			//for Real device
			if(params.getDeviceName().equals("Pixel XL")) {
				waitForVisibility(acceptContinueBtn);
				click(acceptContinueBtn, "User clicks Accept and continue button for accepting cookie");
			}
			//for emulators
			else
			{

				boolean val=find(acceptContinueBtn, 10);
				if(val) {
					click(acceptContinueCookieForEmulator, "User clicks Accept and continue button for accepting cookie");
				}
				else {
					utils.log().info("No cookie Popup is present");
				}				
				//				boolean val=find(acceptContinueCookieForEmulator, 10);
				//				if(val) {
				//					click(acceptContinueCookieForEmulator, "User clicks Accept and continue button for accepting cookie");
				//				}
				//				else {
				//					utils.log().info("No cookie Popup is present");
				//				}
			}
		}
		//for IOS
		else
		{
			boolean val=find(acceptContinueBtn, 5);
			System.out.println("val......."+val);
			if(val) {
				click(acceptContinueBtn, "User clicks Accept and continue button for accepting cookie");
			}
			else
			{
				utils.log().info("No cookie Popup is present");
			}
		}
		return this;
	}

	public LoginPage clickLoginButton() {
		//	changeDriverContextToNative();
		click(btnLogin, "User clicks Login Button");
		return this;
	}


	public LoginPage validateLoginPageTitle(String pageTitle)  {

		waitForVisibility(titleLoginPage);
		String titleValue=getText(titleLoginPage, "Title of Login Page");
		Assert.assertEquals(titleValue, pageTitle);

		utils.log().info("User is in Log-in page");

		acceptCookieInLoginPage();

		return this;
	}


	public LoginPage enterUserName(String userName) {
		clear(usernameTxtFld);	
		sendKeys(usernameTxtFld, userName, "enters username as " + userName);
		return this;
	}

	public LoginPage enterPassword(String password){
		clear(passwordTxtFld);	
		sendKeys(passwordTxtFld, password, "enters password as " + password);
		return this;
	}

	public HomePage clickLoginButtonAfterEnteringUsernamePassword() {
		click(loginButtonInLoginPage, "User clicks Login Button after entering username and password");
		enter2FAforNewDevice("226231");

		return new HomePage();
	}


	public LoginPage acceptCookieInLoginPage() {
		boolean val=find(acceptContinueCookieInLoginPage, 5);
		utils.log().info("cookie popup value " + val);

		if(val) {
			click(acceptContinueCookieInLoginPage, "User clicks cookie popup for accepting cookie in Login Page");
		}
		else {
			utils.log().info("No cookie Popup is present in Login Page");
		}
		return this;
	}


	public LoginPage enterCardNumber(String cardNumber) throws InterruptedException {
		clear(editBoxCardNumber);	
		sendKeys(editBoxCardNumber, cardNumber, "enters card number as " + cardNumber);
		return this;
	}


	public LoginPage enter2FAforNewDevice(String value) {

		boolean val=find(checkEmailTitle, 5);
		if(val) {
			utils.log().info("User is in Check email Page");
			String titleValue=getText(checkEmailTitle, "Title of check Email Page");
			clear(editBox2FA);	
			sendKeys(editBox2FA, value, "enters 2FA value as " + value);

			click(btnContinue);
		}
		else {
			utils.log().info("Check email page is not present as user has already registered with the device");	
		}
		return this;
	}



	public RegistrationPage clickRegisterButton() {
		click(btnRegister, "User clicks Register Button");

		return new RegistrationPage();
	}


	public BrowserPage validateTitleCheckEMailPage(String pageTitle)  {
		waitForVisibility(checkEmailTitle);

		boolean val=find(checkEmailTitle, 5);
		if(val) {
			String titleValue=getText(checkEmailTitle, "Title of check Email Page");

			Assert.assertEquals(titleValue, pageTitle);
		}

		return new BrowserPage();
	}

	public String getErrTxt() {
		String err = getText(errTxt, "error text is - ");
		return err;
	}
	
	public LoginPage validateLoginAndRegistrationButtonIsPresent() {
		boolean val=find(btnLogin, 5);
		if(val) {
			utils.log().info("User is in login Page");	
		}
		
		return this;
	}

}