package com.automationexcercise.Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class CheckoutPage extends TestBase{
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (css="tbody tr")
	List<WebElement> itemsInCart;
	
	@FindBy (css="p.text-center b")
	WebElement emptyCarText;
	
	@FindBy (css="a.check_out")
	WebElement checkoutBtn;
	
	@FindBy (css="textarea.form-control")
	WebElement additionalComnt;
	
	@FindBy (css="input[name='name_on_card']")
	WebElement nameOnCard;
	
	@FindBy (css="input[name='card_number']")
	WebElement cardNo;
	
	@FindBy (css="input[name='cvc']")
	WebElement cvcNo;
	
	@FindBy (css="input[name='expiry_month']")
	WebElement expiryMonth;
	
	@FindBy (css="input[name='expiry_year']")
	WebElement expiryYear;
	
	@FindBy (id="submit")
	WebElement submitBtn;
	
	
	
	public String getEmptyCartText() {
		return Utilities.getTextFromElement(emptyCarText);
	}
	
	public void removeItemFromCart(String itemName) {
        for (WebElement item : itemsInCart) {
            String itemText = item.findElement(By.cssSelector("td h4")).getText();
            if(itemText.equalsIgnoreCase(itemName)){
                WebElement removeButton = item.findElement(By.cssSelector("td.cart_delete a"));
                removeButton.click();
                break;
            }
        }
    }
	
	public void clickonCheckoutBtn() {
		Utilities.clickOnElement(checkoutBtn);
	}
	
	public void enterComments(String comments) {
		Utilities.visibilityOfElement(additionalComnt);
		additionalComnt.sendKeys(comments);;
	}
	
	private void enterNameOnCard(String name) {
		nameOnCard.sendKeys(name);
	}
	
	private void enterCardNo(String cardNum) {
		cardNo.sendKeys(cardNum);
	}
	
	private void enterCVCNo(String cvcNum) {
		cvcNo.sendKeys(cvcNum);
	}
	
	private void enterMonth(String month) {
		expiryMonth.sendKeys(month);
	}
	
	private void enterYear(String year) {
		expiryYear.sendKeys(year);
	}
	
	private void submitOrder() {
		submitBtn.submit();
	}
	
	public OrderPlacedPage enterCardDetails(String name, String cardNum, String cvcNum, String month, String year) {
		enterNameOnCard(name);
		enterCardNo(cardNum);
		enterCVCNo(cvcNum);
		enterMonth(month);
		enterYear(year);
		submitOrder();
		return new OrderPlacedPage();

	}
}
