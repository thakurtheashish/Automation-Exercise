package com.automationexcercise.TestBasePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends TestBase{
	
	private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	public static void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public static void submit(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).submit();
	}
	
	public static String getTextFromElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText().replaceAll("\n", "").trim();
	}
	
	public static void visibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void disapperingOfElement(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	

}
