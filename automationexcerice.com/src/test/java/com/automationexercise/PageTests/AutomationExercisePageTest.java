package com.automationexercise.PageTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationexcercise.Pages.AutomationExercisePage;
import com.automationexcercise.Pages.CheckoutPage;
import com.automationexcercise.Pages.OrderPlacedPage;
import com.automationexcercise.Pages.SignupLoginPage;
import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.Utils.ExcelUtility;

import junit.framework.Assert;

public class AutomationExercisePageTest extends TestBase{
	
	SignupLoginPage signupLogin;
	AutomationExercisePage automationExercisePage;
	CheckoutPage checkoutPage;
	OrderPlacedPage orderPlacedPage;
	
	@BeforeMethod
	public void setup() {
		initialise();
		signupLogin = new SignupLoginPage();
	}
	
	@Test(dataProvider = "LoginData")
	public void validateValidLoginFunctionality(String username, String password) {
		automationExercisePage = signupLogin.enterLoginInfo(username,password);
		String getLoggedinText = automationExercisePage.getLoggedinText();
		Assert.assertTrue("Logged in as", getLoggedinText.contains("Logged in as"));
	}
	
	@DataProvider(name = "LoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\DELL\\Desktop\\loginData.xlsx";
		int rowCount = ExcelUtility.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtility.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtility.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	@Test(groups="addToCart")
	public void validateAddToCartFunctionality() throws InterruptedException {
		automationExercisePage = signupLogin.enterLoginInfo("1example@email.com", "abc123");
		automationExercisePage.addItemToCart("men tshirt");
		automationExercisePage.waitForModalAndContSHopping();
		automationExercisePage.addItemToCart("blue top");
		String itemAddedText = automationExercisePage.getItemAddedText();
		Assert.assertEquals("Added!", itemAddedText);
		
	}

	@Test(dependsOnGroups = "addToCart")
	public void validatePlaceOrderFunctionality() {
		automationExercisePage = signupLogin.enterLoginInfo("1example@email.com", "abc123");
		checkoutPage = automationExercisePage.clickcartBtn();
		checkoutPage.clickonCheckoutBtn();
		checkoutPage.enterComments("Deliver in Evening");
		checkoutPage.clickonCheckoutBtn();
		orderPlacedPage = checkoutPage.enterCardDetails("Ashish", "123456789", "343", "02", "2027");
		String orderPlacedText = orderPlacedPage.getOrderPlacedText();
		Assert.assertEquals("ORDER PLACED!", orderPlacedText);
		automationExercisePage = orderPlacedPage.clickContBtn();
		String getLoggedinText = automationExercisePage.getLoggedinText();
		Assert.assertTrue("Logged in as", getLoggedinText.contains("Logged in as"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
