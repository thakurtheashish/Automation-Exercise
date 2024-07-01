package com.automationexcercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class OrderPlacedPage extends TestBase{
	
	public OrderPlacedPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="h2.title b")
	WebElement orderPlacedText;
	
	@FindBy (css="div.pull-right a.btn")
	WebElement contBtn;
	
	public String getOrderPlacedText() {
		return Utilities.getTextFromElement(orderPlacedText);
	}
	
	public AutomationExercisePage clickContBtn() {
		Utilities.clickOnElement(contBtn);
		return new AutomationExercisePage();
	}
	
	

}
