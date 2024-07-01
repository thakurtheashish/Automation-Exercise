package com.automationexcercise.listeners;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.automationexcercise.TestBasePackage.TestBase;

public class WebDriverEvent extends TestBase implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("Accepting an alert!");
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("Accepted an alert");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to URL : " + url);
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to URL : " + url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		logger.info("Finding an element:  " + by);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Found the element:  " + by);
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking on element:  " + element.getText());
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		logger.info("Clicked on element:  " + element.getText());
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		logger.info("Getting text from element  " + element.getText());
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("Text from element  " + element.getText());
		
	}

}
