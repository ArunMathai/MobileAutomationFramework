package Pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PersonalDetailsPage extends BasePage {
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy (id="//com.ga.loyalty.android.nectar.activities:id/title")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Your details\"]")
	private MobileElement myDetailsPageTitle;

	@AndroidFindBy (id="//com.ga.loyalty.android.nectar.activities:id/nameTextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Name\"]/../..//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
	private MobileElement usernameValue;
	
	@AndroidFindBy (id="//com.ga.loyalty.android.nectar.activities:id/emailTextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Email address\"]/../..//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]")
	private MobileElement emailIdValue;
	
	@AndroidFindBy (id="//com.ga.loyalty.android.nectar.activities:id/nectarIdTextView")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeApplication[@name=\"NectarPreProd\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
	private MobileElement cardNumberValue;
	
	@AndroidFindBy (xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeApplication[@name=\"NectarPreProd\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView")
	private MobileElement backBtnImage;
	
	
	
	
	public PersonalDetailsPage validateTitlePage(String pageTitle)  {
		waitForVisibility(myDetailsPageTitle);
		pageTitle=pageTitle.replace('_', ' ');

		String titleValue=getText(myDetailsPageTitle, "Title of My Details Page");
		Assert.assertEquals(titleValue, pageTitle);
		return this;
	}
	public PersonalDetailsPage validateUsername(String userName)  {
		waitForVisibility(usernameValue);
		String titleValue=getText(usernameValue, "UserName value");
		Assert.assertEquals(titleValue, userName);
		return this;
	}
	
	public PersonalDetailsPage validateEmailId(String emailId)  {
		waitForVisibility(emailIdValue);
		String titleValue=getText(emailIdValue, "emailId value");
		Assert.assertEquals(titleValue, emailId);
		return this;
	}
	
	public PersonalDetailsPage validateCardNumber(String cardNumber)  {
		waitForVisibility(cardNumberValue);
		String titleValue=getText(cardNumberValue, "emailId value");
		titleValue="98263000  "+titleValue;  
		Assert.assertEquals(titleValue, cardNumber);
		return this;
	}

	
}