package com.automationexcercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class SignupLoginPage extends TestBase {

	public SignupLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="input[data-qa='signup-name']")
	WebElement signUpName;
	
	@FindBy (css="input[data-qa='signup-email']")
	WebElement signUpEmail;
	
	@FindBy (css="button[data-qa='signup-button']")
	WebElement signUpBtn;
	
	@FindBy (css="input[data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy (css="input[data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy (css="button[data-qa='login-button']")
	WebElement loginBtn;
	
	@FindBy (css="div.login-form p")
	WebElement invalidLoginText;
	
	@FindBy (id="susbscribe_email")
	WebElement subscribe;
	
	@FindBy (css="div.alert-success")
	WebElement subscribeText;
	
	@FindBy (id="subscribe")
	WebElement subscribeBtn;
	
	@FindBy (css="div.login-form h2")
	WebElement loginText;
	
	@FindBy (css="div.signup-form p")
	WebElement signupText;
	
	public String getLoginText() {
		return Utilities.getTextFromElement(loginText);
	}
	
	public String getSignupText() {
		return Utilities.getTextFromElement(signupText);
	}
	
	
	private void enterSignupName(String name) {
		signUpName.sendKeys(name);
	}
	
	private void enterSignupEmail(String email) {
		signUpEmail.sendKeys(email);
	}
	
	private void enterLoginEmail(String email) {
		loginEmail.sendKeys(email);
	}
	
	private void enterPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	private void subscription(String email) {
		subscribe.sendKeys(email);
	}
	
	private void clickSubsBtn() {
		subscribeBtn.submit();
	}
	
	public String subscribeTo(String email) {
		subscription(email);
		clickSubsBtn();
		return subscribeText.getText().trim();
	}
	
	public String getInvalidLoginText() {
		return Utilities.getTextFromElement(invalidLoginText);
	}
	
	public SignupPage enterSignupInfo(String name, String email) {
		enterSignupName(name);
		enterSignupEmail(email);
		Utilities.submit(signUpBtn);
		return new SignupPage();
	}
	
	public AutomationExercisePage enterLoginInfo(String email, String password) {
		enterLoginEmail(email);
		enterPassword(password);
		Utilities.submit(loginBtn);
		return new AutomationExercisePage();
	}
}
