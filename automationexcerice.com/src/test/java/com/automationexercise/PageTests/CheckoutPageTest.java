package com.automationexercise.PageTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.Pages.AutomationExercisePage;
import com.automationexcercise.Pages.CheckoutPage;
import com.automationexcercise.Pages.SignupLoginPage;
import com.automationexcercise.TestBasePackage.TestBase;

import junit.framework.Assert;

public class CheckoutPageTest extends TestBase{
	
	SignupLoginPage signupLogin;
	AutomationExercisePage automationExcersiePage;
	CheckoutPage checkoutPage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		signupLogin = new SignupLoginPage();
	}
	
	@Test(dependsOnGroups = "addToCart")
	public void validateRemoveItemFromCheckout() {
		automationExcersiePage = signupLogin.enterLoginInfo("1example@email.com", "abc123");
		checkoutPage = automationExcersiePage.clickcartBtn();
		checkoutPage.removeItemFromCart("blue top");
		checkoutPage.removeItemFromCart("men tshirt");
		
		String updatedCartTExt = checkoutPage.getEmptyCartText();
		Assert.assertEquals("Cart is empty!", updatedCartTExt);
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}


}
