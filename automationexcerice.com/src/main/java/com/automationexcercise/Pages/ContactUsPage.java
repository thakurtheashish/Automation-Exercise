package com.automationexcercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class ContactUsPage extends TestBase{
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy (xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy (xpath="//input[@name='subject']")
	WebElement subject;
	
	@FindBy (id="message")
	WebElement message;
	
	@FindBy (xpath="//input[@name='submit']")
	WebElement submitBtn;
	
	@FindBy (css="div.contact-form div.alert-success")
	WebElement alertText;
	
	private void enterName(String nameN) {
		name.sendKeys(nameN);
	}
	
	private void enterEmail(String eMail) {
		email.sendKeys(eMail);
	}
	
	private void enterSubject(String subjects) {
		subject.sendKeys(subjects);
	}
	
	private void enterMessage(String messages) {
		message.sendKeys(messages);
	}
	
	private void submitForm() {
		Utilities.submit(submitBtn);
	}
	
	public void fillContactUsForm(String nameN, String eMail, String subjects, String messages) {
		enterName(nameN);
		enterEmail(eMail);
		enterSubject(subjects);
		enterMessage(messages);
		submitForm();
	}
	
	public String getAlertText() {
		return Utilities.getTextFromElement(alertText);
	}
	
	

	
	
}
