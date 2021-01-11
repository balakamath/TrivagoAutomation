package com.trivago.automationframework.trivago;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.trivago.automationframework.constants.Constants.DriverNames;
import com.trivago.automationframework.constants.Constants.PageUrls;
import com.trivago.automationframework.factory.DriverFactory;
import com.trivago.automationframework.factory.TrivagoPageFactory;
import com.trivago.automationframework.interfaces.DriverInterface;


public class BaseTest {
	
	private final static Logger LOG = Logger.getLogger(BaseTest.class);
	
	public DriverInterface driverInterface;
	public TrivagoPageFactory trivagoPageFactory;
	public WebDriver driver;
	
	@BeforeClass
	public void baseBeforeClass() {
		launchWebDriver();
	}
	
	@AfterClass
	public void methodAfterClass() {
		this.driver.close();
	}

	public void launchWebDriver() {
		
		LOG.info("Launching the Selenium driver");
		this.driverInterface = DriverFactory.getInstance(DriverNames.CHROME).getDriverInterface();
		this.trivagoPageFactory = new TrivagoPageFactory(this.driverInterface);
		this.driver = (WebDriver) driverInterface.getDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LOG.info("Opening Trivago Website");
		this.driver.get(PageUrls.TRIVAGO_MAIN_PAGE);
		this.driver.manage().deleteAllCookies();
	}
}
