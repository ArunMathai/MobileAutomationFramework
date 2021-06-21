package Pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountDetailsPage extends BasePage{
	TestUtils utils = new TestUtils();


	//XCUIElementTypeStaticText[@name="Your account"]
	//XCUIElementTypeStaticText[@name="Personal details"]

	//XCUIElementTypeStaticText[@name="Log out"]

	//XCUIElementTypeButton[@name="Log out"]

	//XCUIElementTypeButton[@name="Cancel"]

	//XCUIElementTypeStaticText[@name="Your details"]
	//XCUIElementTypeStaticText[@name="Name"]/../..//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]
	//XCUIElementTypeStaticText[@name="Email address"]/../..//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]
	//cardNumber
	//XCUIElementTypeApplication[@name="NectarPreProd"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView

	@AndroidFindBy (xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name='Personal details']")
	private MobileElement personalDetailsBtn;

	@AndroidFindBy (xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Log out\"]")
	private MobileElement logOutBtn;

	@AndroidFindBy (xpath="//com.ga.loyalty.android.nectar.activities:id/title")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Your account\"]")
	private MobileElement AccountDetailsPageTitle;

	@AndroidFindBy (xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Log out\"]")
	private MobileElement settingsBtn;

	
	@AndroidFindBy (id="android:id/button1")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeButton[@name=\"Log out\"]")
	private MobileElement logOutInPopup;
	
	public AccountDetailsPage pressSettingsBtn() {
		click(settingsBtn, "press Settings button");
		return this;
	}

	public AccountDetailsPage clickPersonalDetailsTab()  {
		click(personalDetailsBtn, "User clicks on Personal Details tab in the Account details page");
		return this;
	}
	public AccountDetailsPage clickLogoutButton()  {
		click(logOutBtn, "User clicks on log out button in the Account details page");
		return this;
	}
	public AccountDetailsPage clickLogoutBtnInPopup()  {
		click(logOutInPopup, "User clicks on log out button in the popup");
		return this;
	}
	public AccountDetailsPage validateTitlePage(String pageTitle)  {
		waitForVisibility(AccountDetailsPageTitle);
		pageTitle=pageTitle.replace('_', ' ');
		String titleValue=getText(AccountDetailsPageTitle, "Title of My Account Page");
		Assert.assertEquals(titleValue, pageTitle);

		return this;
	}

	public AccountDetailsPage clickSettingsTab()  {
		click(settingsBtn, "User clicks on Settings tab in the Account details page");
		return this;
	}

	public AccountDetailsPage clickLogoutButtonForBackgroundLogout()  {
		boolean valLogoutBtn=find(logOutBtn, 5);

		if(valLogoutBtn) {
			utils.log().info("User clicks on the Logout Button");
			clickLogoutButton();
			clickLogoutBtnInPopup();
		}
		else {
			utils.log().info("User is not in home page");
		}
		return this;
	}
}
