package Pages;

import org.junit.Assert;

import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CardPage extends BasePage {
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy (id="findout")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Card\"]")
	private MobileElement cardPageTitle;

	@AndroidFindBy (id="findout")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
	private MobileElement usernameValue;
	
	@AndroidFindBy (id="findout")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeStaticText[@name=\"Add to Apple Wallet\"]")
	private MobileElement btnAddToAppleWallet;
	
	@AndroidFindBy (id="findout")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeTextView[2]")
	private MobileElement cardNumberSecondPart;
	
	@AndroidFindBy (id="findout")
	@iOSXCUITFindBy (xpath="//XCUIElementTypeOther/XCUIElementTypeTextView[1]")
	private MobileElement cardNumberFirstPart;
	
	
	public CardPage validateCardTitlePage(String pageTitle)  {
		waitForVisibility(cardPageTitle);
		String titleValue=getText(cardPageTitle, "Title of card page");
		Assert.assertEquals(titleValue, pageTitle);
		return this;
	}
	public CardPage validateUsername(String userName)  {
		waitForVisibility(usernameValue);
		String titleValue=getText(usernameValue, "UserName value");
		Assert.assertEquals(titleValue, userName);
		return this;
	}
	public CardPage validateCardNumber(String cardNumberValue)  {
		waitForVisibility(cardNumberSecondPart);
		waitForVisibility(cardNumberFirstPart);

		String cardSecondpart=getText(cardNumberSecondPart, "Card number Second part");

		Assert.assertEquals(cardSecondpart, cardNumberValue);
		return this;
	}	
}