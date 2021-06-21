package com.qa.stepdefs;

import org.junit.Assert;

import Pages.AccountDetailsPage;
import Pages.BrowserPage;
import Pages.CardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PersonalDetailsPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class UserStepdefs {

	//Accepts cookie and Clicks "Login"/ Register 
	@When("^I click \"([^\"]*)\" button$")
	public void iClickLoginOrRegister(String val) throws InterruptedException {
		LoginPage lp=new LoginPage();
		lp.acceptCookies();
		if(val.equals("Login")) {
			lp.clickLoginButton();
		}else if(val.equals("Register")){
			lp.clickRegisterButton();
		}
//		else if(val.equals("Accounts")){
//			new HomePage().clickMyAccountInHomePage();
//		}
//		else if(val.equals("Your_details")){
//			new AccountDetailsPage().clickPersonalDetailsTab();
//	}
	}

	@When("^I should be in \"([^\"]*)\" page$")
	public void iShouldbeInPage(String titleValue) throws InterruptedException {

		if(titleValue.equals("check your email")) {
			new LoginPage().validateTitleCheckEMailPage(titleValue);
		}
		else if(titleValue.equals("Log in")) {
			new LoginPage().validateLoginPageTitle(titleValue);

		}
		else if(titleValue.equals("Home")) {
			new HomePage().validateUserIsInHomepage();
		}
		else if(titleValue.equals("Your_account")) {
			new AccountDetailsPage().validateTitlePage(titleValue);
		}
		else if(titleValue.equals("Your_details")) {
			new PersonalDetailsPage().validateTitlePage(titleValue);
		}
		else if(titleValue.equals("Card")) {
			new CardPage().validateCardTitlePage(titleValue);
		}
		else if(titleValue.equals("Welcome")) {
			new LoginPage().validateLoginAndRegistrationButtonIsPresent();
		}
		
	}

	@When("I click \"([^\"]*)\" option for nectar card$")
	public void i_click_option_for_nectar_card(String nectarCardYesOrNo) {
		RegistrationPage rp=new RegistrationPage();
		rp.clickYesOrNoOptionForHavingNectarCard(nectarCardYesOrNo);
	}

	@When("I enter email address as \"([^\"]*)\"$")
	public void i_enter_email_address_as(String emailAddress) {
		try {
			new RegistrationPage().enterEmailId(emailAddress);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String btnName) {
		if(btnName.equals("continue")) {
			new RegistrationPage().clickContinueButton();
		}
		else if(btnName.equals("login")) {
			new LoginPage().clickLoginButtonAfterEnteringUsernamePassword();	
		}
		else if(btnName.equals("Accounts")){
			new HomePage().clickMyAccountInHomePage();
		}
		else if(btnName.equals("Your_details")){
			new AccountDetailsPage().clickPersonalDetailsTab();
	}
		else if(btnName.equals("Card")){
			new HomePage().clickCardTabInHomePage();
	}
	}


	@When("I enter card number \"([^\"]*)\"$")
	public void i_enter_cardNumber(String cardNumber) {
		try {
			new LoginPage().enterCardNumber(cardNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Validating Error Message 
	@When("I should get proper error message \"([^\"]*)\"$")
	public void i_should_get_proper_errorMessage(String errorMessage) {
		new RegistrationPage().validateErrorMessage(errorMessage);

	}


	@Then("^login should fail with an error \"([^\"]*)\"$")
	public void loginShouldFailWithAnError(String err) {
		Assert.assertEquals(new LoginPage().getErrTxt(), err);
	}

	@Then("^I should see Products page with title \"([^\"]*)\"$")
	public void iShouldSeeProductsPageWithTitle(String title) {
		//	Assert.assertEquals(new ProductsPage().getTitle(), title);
	}

	@When("I open Browser \"([^\"]*)\"$")
	public void i_openBrowser(String emailId) {
		new BrowserPage().openBrowser(emailId);
	}
	

	@When("^I enter email id as \"([^\"]*)\"$")
	public void iEnterEmailAs(String emailId) {
		new LoginPage().enterUserName(emailId);
	}
	@When("^I enter password as \"([^\"]*)\"$")
	public void iEnterPasswordAs(String password) {
		new LoginPage().enterPassword(password);
	}

	@When("I should be able to validate the \"([^\\\"]*)\" \"([^\"]*)\"$")
	public void i_shouldBeAbleToValidateTheDetails(String valueType,String personalDetails) {
		PersonalDetailsPage pd =new PersonalDetailsPage();
		CardPage cp =new CardPage();

		if(valueType.equals("username")) {
			pd.validateUsername(personalDetails);
		}
		else if(valueType.equals("emailId")) {
			pd.validateEmailId(personalDetails);
		}
		else if(valueType.equals("cardNumber")) {
			pd.validateCardNumber(personalDetails);
		}
		else if(valueType.equals("CardPage_Username")) {
			cp.validateUsername(personalDetails);
		}
		else if(valueType.equals("CardPage_Cardnumber")) {
			cp.validateCardNumber(personalDetails);
		}
	}
	
	@Then("I am Logged in$")
	public void ValidateUserLoggedIn() {
		
		new HomePage().validateInBackgroundIfUserIsInHomePage();
	}
	@Then("I click logout button inside Accounts section$")
	public void i_click_logout_buttoninsideAccountssection() {
		new AccountDetailsPage().clickLogoutButtonForBackgroundLogout();
	}
	
}