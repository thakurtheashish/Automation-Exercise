package com.automationexercise.PageTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.Pages.AutomationExercisePage;
import com.automationexcercise.Pages.ContactUsPage;
import com.automationexcercise.Pages.SignupLoginPage;
import com.automationexcercise.TestBasePackage.TestBase;

import junit.framework.Assert;

public class ContactUsPageTest extends TestBase{
	
	SignupLoginPage signupLogin;
	AutomationExercisePage automationExercisePage;
	ContactUsPage contactusPage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		signupLogin = new SignupLoginPage();
	}
	
	@Test
	public void validateContactUsFunctionality(){
		automationExercisePage = signupLogin.enterLoginInfo("1example@email.com", "abc123");
		contactusPage = automationExercisePage.clickContactUs();
		contactusPage.fillContactUsForm("Ashish", "1example@email.com", "Order not complete", "My order was incomplete");
		driver.switchTo().alert().accept();
		String successText = contactusPage.getAlertText();
		Assert.assertEquals("Success! Your details have been submitted successfully.", successText);
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
