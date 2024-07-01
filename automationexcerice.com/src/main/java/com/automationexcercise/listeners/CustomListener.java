package com.automationexcercise.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationexcercise.TestBasePackage.TestBase;
import com.automationexcercise.Utils.ScreenShot;

public class CustomListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		logger.info("Test Started : " + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed : " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test Failed : " + result.getMethod().getMethodName());
		logger.info("Test Failed, Taking Screenshot!!!");
		ScreenShot.takeFailedTestScreenShot(result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped : " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
