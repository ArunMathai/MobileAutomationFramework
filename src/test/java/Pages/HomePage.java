package Pages;

import org.junit.Assert;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;



public class HomePage extends BasePage{



	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/closeBtn")
	@iOSXCUITFindBy (id = "WhiteClose")
	private MobileElement closeButtonPopupInHomePage;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/greetingsText")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name='NectarPreProd']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
	private MobileElement greetigsText;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/valueTickerTextView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name=\"NectarPreProd\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther")
	private MobileElement pointsView;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/pointsWorthTitle")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name=\"NectarPreProd\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther")
	private MobileElement pointsWorthTitle;


	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/spendPointsButton")
	@iOSXCUITFindBy (id = "Not in ios")
	private MobileElement spendPointsLink;


	@AndroidFindBy (xpath = "//android.widget.FrameLayout[@content-desc=\"Saved\"]/android.widget.ImageView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[@name='Saved'] ")
	private MobileElement savedtab;

	@AndroidFindBy (xpath = "//android.widget.FrameLayout[@content-desc=\"Activity\"]/android.widget.ImageView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[@name='Activity'] ")
	private MobileElement activityTab;

	@AndroidFindBy (xpath = "//android.widget.FrameLayout[@content-desc=\"Card\"]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[@name='Card'] ")
	private MobileElement cardTab;

	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/action_home")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeTabBar/XCUIElementTypeButton[@name='Home'] ")
	private MobileElement hometab;


	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/action_home")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeApplication[@name='NectarPreProd']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
	private MobileElement btnSettings;

	@AndroidFindBy (xpath = "NoLocators")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='Not right now']")
	private MobileElement btnNotificationsNotRightNow;

	@AndroidFindBy (xpath = "NoLocators")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Yes, turn on notifications']")
	private MobileElement btnNotificationsYesTurnOn;

	@AndroidFindBy (xpath = "NoLocators")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Would you like to turn on app notifications?']")
	private MobileElement titleAppNotificationPage;


	@AndroidFindBy (id = "com.ga.loyalty.android.nectar.activities:id/accountButton")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name='Account and settings.']")
	private MobileElement btnMyAccount;


	GlobalParams params = new GlobalParams();
	DriverManager dm=new DriverManager();

	public HomePage(){
	}


	public HomePage closeHomePagePopup() {

		//		if(params.getPlatformName().equals("Android"))
		//		{		
		//	waitForVisibility(greetigsText);

		boolean val=find(closeButtonPopupInHomePage, 8);
		if(val) {
			click(closeButtonPopupInHomePage, "User clicks close button in the HomePage popup");
		}
		else {
			utils.log().info("No popup is present in Home Page");
		}
		//	}
		return this;
	}



	public HomePage turnNotificationsOffInIos() {
		//boolean val1=find(titleAppNotificationPage, 8);
		//	changeDriverContextToWeb();
		//	waitForVisibility(titleAppNotificationPage);
		//	waitForVisibility(btnNotificationsNotRightNow);
		//	click(btnNotificationsNotRightNow, "User clicks on the turn off Notification in the page");

		boolean val=find(btnNotificationsNotRightNow, 10);
		if(val) {
			click(btnNotificationsNotRightNow, "User clicks on the turn off Notification in the page");
		}
		else {
			utils.log().info("No Notification is present in the page as user has already turned off the notification");
		}
		return this;
	}


	public HomePage turnNotificationsOnInIos() {

		boolean val=find(btnNotificationsYesTurnOn, 10);
		if(val) {
			click(btnNotificationsYesTurnOn, "User clicks on the turn On Notification in the page");

			dm.getDriver().switchTo().alert().accept();		

		}
		else {
			utils.log().info("No Notification is present in the page as user has already turned On the notification");
		}
		return this;
	}

	public HomePage validateUserIsInHomepage() throws InterruptedException  {
		if(params.getPlatformName().equals("Android"))
		{
			new LoginPage().acceptCookies();
			closeHomePagePopup();
			waitForVisibility(spendPointsLink);
		}
		else {
			turnNotificationsOnInIos();	
			closeHomePagePopup();
		}
	//	Thread.sleep(70000);
		//waitForVisibility(greetigsText);
	//	waitForVisibility(pointsView);
	//	waitForVisibility(pointsWorthTitle);
		waitForVisibility(btnMyAccount);
		waitForVisibility(hometab);
		waitForVisibility(savedtab);
		waitForVisibility(activityTab);
		waitForVisibility(cardTab);

		return this;
	}


	public AccountDetailsPage clickMyAccountInHomePage()  {
		click(btnMyAccount, "User clicks on My account button in the home page");
		return new AccountDetailsPage();
	}
	public CardPage clickCardTabInHomePage()  {
		click(cardTab, "User clicks on Card tab in bottom of the home page");
		return new CardPage();
	}

	public HomePage clickHomeTabInHomePage()  {
		click(hometab, "User clicks on Home tab in bottom of the home page");
		return this;

	}
	public HomePage clickActivityTabInHomePage()  {
		click(activityTab, "User clicks on Activity tab in bottom of the home page");
		return this;

	}
	public HomePage clickSavedTabInHomePage()  {
		click(activityTab, "User clicks on Saved tab in bottom of the home page");
		return this;
	}
	
	
	public HomePage validateInBackgroundIfUserIsInHomePage()  {
		
		boolean valGreetingsText=find(greetigsText, 5);
		boolean valHometab=find(hometab, 5);
		boolean valSavedTab=find(savedtab, 5);
		boolean valCardTab=find(cardTab, 5);

		if(valGreetingsText) {
			utils.log().info("User is in Home Page");
			clickMyAccountInHomePage();
		}
		else if(valHometab){
			utils.log().info("User is in Home Page");
			clickMyAccountInHomePage();
		}
		else if(valSavedTab){
			utils.log().info("User is in Home Page");
			clickMyAccountInHomePage();
		}
		else if(valSavedTab){
			utils.log().info("User is in Home Page");
		}
		return this;
	}
}

