package com.automationexercise.PageTests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexcercise.Pages.AutomationExercisePage;
import com.automationexcercise.Pages.SignupLoginPage;
import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.Utils.ExcelUtility;

import junit.framework.Assert;


public class SignupLoginPageTest extends TestBase{
	
	SignupLoginPage signupLogin;
	AutomationExercisePage automationExcersiePage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		signupLogin = new SignupLoginPage();
	}
	
	@Test
	public void validateInvalidLoginFunctionality() {
		signupLogin.enterLoginInfo("1example@email.com", "564sad");
		String invalidLoginText = signupLogin.getInvalidLoginText();
		Assert.assertEquals("Your email or password is incorrect!", invalidLoginText);
	}
	
	@Test
	public void validateSubscriptionFunctionality() {
		String subscriptionText = signupLogin.subscribeTo("1example@email.com");
		Assert.assertEquals("You have been successfully subscribed!", subscriptionText);
	}
	
	@Test
	public void validateLogoutFunctionality() throws InterruptedException {
		automationExcersiePage = signupLogin.enterLoginInfo("1example@email.com", "abc123");
		signupLogin = automationExcersiePage.clickLogoutBtn();
		String getLoginText = signupLogin.getLoginText();
		Assert.assertEquals("Login to your account", getLoginText);	
		}
	
	@Test
	public void validateSignupWithExisitngEmailFunctionality() {
		signupLogin.enterSignupInfo("Ashish", "1example@email.com");
		String getSignupText = signupLogin.getSignupText();
		Assert.assertEquals("Email Address already exist!", getSignupText);	
		}
	

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	
	
}
