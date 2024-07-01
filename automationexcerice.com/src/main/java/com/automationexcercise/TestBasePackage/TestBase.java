package com.automationexcercise.TestBasePackage;

import java.time.Duration;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.automationexcercise.browsers.Browser;
import com.automationexcercise.listeners.WebDriverEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	private final static Browser webbrowser = Browser.CHROME;
	public static Logger logger;
	private WebDriverEvent events;
	private EventFiringWebDriver eDriver;
	
	
	private final String URL = "https://www.automationexercise.com/login";

	@BeforeClass
	public void setUpLogger() {
		logger = logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);		
	}
	
	public void initialise() {
		initialiseWebDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
	}
	
	private void initialiseWebDriver() {
		switch (webbrowser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new InvalidArgumentException("Invalid Browser");	
		}
		eDriver = new EventFiringWebDriver(driver);
		events = new WebDriverEvent();
		eDriver.register(events);
		driver = eDriver;
		
	}
		
		public void tearDown() {
			driver.quit();
		}
	
		public void selectDropdown(WebElement element, String value) {
			Select select = new Select(element);
			try {
				select.selectByValue(value);
			} catch (Exception e) {
				throw new InvalidArgumentException("Invalid value");
			}
		}
	
	

}
