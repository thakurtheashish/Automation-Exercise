package com.automationexcercise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.TestBasePackage.Utilities;

public class SignupPage extends TestBase {

	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[text()=\"Enter Account Information\"]")
	WebElement validateSignupPageText;

	@FindBy(id = "id_gender1")
	WebElement mrBtn;

	@FindBy(id = "id_gender2")
	WebElement mrsBtn;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "newsletter")
	WebElement newsletter;

	@FindBy(id = "optin")
	WebElement specialOffers;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobileNum;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createActBtn;

	private void clickTitle2() {
		mrsBtn.click();
	}

	private void enterPassowrd(String pswd) {
		password.sendKeys(pswd);
	}

	private void enterFirstName(String firstN) {
		firstName.sendKeys(firstN);
	}

	private void enterLastName(String lastN) {
		lastName.sendKeys(lastN);
	}

	private void enterCompanyname(String compnay) {
		company.sendKeys(compnay);
	}

	private void enterAddress(String address) {
		address1.sendKeys(address);
	}

	private void enterAddress2(String address) {
		address2.sendKeys(address);
	}

	private void enterState(String stateN) {
		state.sendKeys(stateN);
	}

	private void enterCity(String cityN) {
		city.sendKeys(cityN);
	}

	private void enterZipcode(String zipC) {
		zipcode.sendKeys(zipC);
	}

	private void enterMobile(String mobileN) {
		mobileNum.sendKeys(mobileN);
	}

	public AccountCreatedPage signUpInformation(String pwsd, String day, String monthN, String year, String firstN, String LastN,
			String companyN, String adrs, String adrs2, String countryName, String stateN, String cityN, String zipC,
			String mobileN) {
		Utilities.clickOnElement(mrBtn);
		enterPassowrd(pwsd);
		selectDropdown(days, day);
		selectDropdown(months, monthN);
		selectDropdown(years, year);
		Utilities.clickOnElement(newsletter);
		Utilities.clickOnElement(specialOffers);
		enterFirstName(firstN);
		enterLastName(LastN);
		enterCompanyname(companyN);
		enterAddress(adrs);
		enterAddress2(adrs2);
		selectDropdown(country, countryName);
		enterState(stateN);
		enterCity(cityN);
		enterZipcode(zipC);
		enterMobile(mobileN);
		Utilities.submit(createActBtn);
		return new AccountCreatedPage();
	}
}
