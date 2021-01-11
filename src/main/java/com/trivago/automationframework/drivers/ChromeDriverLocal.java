package com.trivago.automationframework.drivers;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.trivago.automationframework.interfaces.DriverInterface;

public class ChromeDriverLocal implements DriverInterface{
	
	private final static Logger LOG = Logger.getLogger(ChromeDriverLocal.class);
	private WebDriver driver;

	public ChromeDriverLocal() {
		LOG.trace("Launching the chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");
		this.driver = new ChromeDriver(options); 
		this.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		this.driver.manage().deleteAllCookies();
	}

	@Override
	public Object getDriver() {
		return this.driver;
	}

	@Override
	public void closeDriver() {
		this.driver.quit();
	}

}
