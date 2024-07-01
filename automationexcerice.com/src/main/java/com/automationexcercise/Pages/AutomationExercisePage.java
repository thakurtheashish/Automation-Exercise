package com.automationexcercise.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class AutomationExercisePage extends TestBase {

	public AutomationExercisePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.navbar-nav li:last-of-type")
	WebElement signUpName;

	@FindBy(css = "ul.navbar-nav li:nth-of-type(4)")
	WebElement logoutBtn;
	
	@FindBy(css = "ul.navbar-nav li:nth-of-type(3)")
	WebElement cartBtn;

	@FindBy(css = "ul.navbar-nav li:nth-of-type(9)")
	WebElement contactUsBtn;
	
	@FindBy(css = "div.features_items div.single-products")
	List<WebElement> products;

	@FindBy(css = "h4.w-100")
	WebElement itemAddedText;

	@FindBy(css = "div.modal-content div.modal-footer")
	WebElement continueShoppingBtn;
	
	@FindBy(id = "cartModal")
	WebElement itemAddedBox;
	
	public ContactUsPage clickContactUs(){
		try {
		Utilities.clickOnElement(contactUsBtn);
		} catch(StaleElementReferenceException e) {
			driver.navigate().back();
		Utilities.clickOnElement(contactUsBtn);
		}
		return new ContactUsPage();
	}
	
	public CheckoutPage clickcartBtn() {
		Utilities.clickOnElement(cartBtn);
		return new CheckoutPage();	
	}

	public void clickContShoppingBtn() {
		Utilities.clickOnElement(continueShoppingBtn);
	}

	public String getItemAddedText() {
		return Utilities.getTextFromElement(itemAddedText);
	}

	public SignupLoginPage clickLogoutBtn() throws InterruptedException {
		Thread.sleep(2000);
		Utilities.clickOnElement(logoutBtn);
		return new SignupLoginPage();
	}

	public String getLoggedinText() {
		return Utilities.getTextFromElement(signUpName);
	}

	public void addItemToCart(String item) {
		for (WebElement product : products) {
			String productName = product.findElement(By.cssSelector("p")).getText();
			if (productName.equalsIgnoreCase(item)) {
				product.findElement(By.cssSelector("a.add-to-cart")).click();
				break;
			}
		}
	}

	public void waitForModalAndContSHopping() {

		Utilities.visibilityOfElement(itemAddedBox);
		Utilities.clickOnElement(continueShoppingBtn);
		Utilities.disapperingOfElement(itemAddedBox);

	}

}
