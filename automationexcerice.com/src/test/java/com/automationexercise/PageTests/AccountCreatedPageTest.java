package com.automationexercise.PageTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.Pages.AccountCreatedPage;
import com.automationexcercise.Pages.SignupLoginPage;
import com.automationexcercise.Pages.SignupPage;
import com.automationexcercise.TestBasePackage.TestBase;

import junit.framework.Assert;

public class AccountCreatedPageTest extends TestBase {

	SignupLoginPage signupLogin;
	SignupPage signup;
	AccountCreatedPage accountCreatedPage;

	@BeforeMethod
	public void setup() {
		initialise();
		signupLogin = new SignupLoginPage();
	}

	@Test
	public void validateAccountCreationFunctionality() {
		signup = signupLogin.enterSignupInfo("Ash", "11email@email.com");
		accountCreatedPage = signup.signUpInformation("abc123", "5", "6", "2002", "Ash", "Thakur", "TD", "123 45St", "NW", "Canada", "AB",
				"Edmonton", "T5z12as", "123456789");
		String accCreatedText = accountCreatedPage.getAccCreatedtext();
		Assert.assertEquals("ACCOUNT CREATED!", accCreatedText);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
