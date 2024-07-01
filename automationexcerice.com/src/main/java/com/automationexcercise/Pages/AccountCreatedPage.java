package com.automationexcercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class AccountCreatedPage extends TestBase{
	
	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h2.text-center")
	WebElement accCreatedText;
	
	public String getAccCreatedtext() {
		return Utilities.getTextFromElement(accCreatedText);
	}

}
