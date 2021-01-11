package com.trivago.automationframework.page.trivago;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * 
 * This Page contains locators and helper methods of Main Page
 *
 */
public class MainPage extends AbstractWebdriverPage {

	@FindBy(xpath = "//*[text()='Log in']")
	private static WebElement loginButton;

	@FindBy(xpath = "//*[@id='querytext']")
	private static WebElement searchLocationField;

	@FindBy(xpath = "//*[@class='ssg-suggestions']//div/span[1]")
	private static List<WebElement> primaryLocations;

	@FindBy(xpath = "//*[@class='ssg-suggestions']//div/span[2]")
	private static List<WebElement> regions;

	@FindBy(xpath = "//*[@key='checkInButton']//time[@class='dealform-button__label']")
	private static WebElement checkInDate;

	@FindBy(xpath = "//*[@class='cal-day-wrap']//time")
	private static List<WebElement> dateList;
	
	@FindBy(xpath = "//*[@id='adults-input']")
	private static WebElement adultField;
	
	@FindBy(xpath = "//*[@class='btn btn--primary btn--regular search-button js-search-button']")
	private static WebElement searchButton;
	
	@FindBy(xpath = "//*[@class='btn btn--primary btn--small btn--apply-config']")
	private static WebElement applyButton;

	private final static Logger LOG = Logger.getLogger(MainPage.class);

	public MainPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}

	/**
	 * This method returns url of the main page
	 * 
	 * @return String : Returns url of the Main Page
	 */
	public String getMainPageUrl() {
		LOG.debug("Returns url of the page");
		return this.getCurrentPageUrl();
	}

	/**
	 * Click on Login button of main page
	 */
	public void clickLoginButton() {
		LOG.debug("Click on Log in button");
		this.clickElement(loginButton);
	}

	/**
	 * Searches and clicks location based on nation
	 * 
	 * @param location
	 * @param nation
	 */
	public void searchAndSelectLocation(String location, String nation) {
		LOG.debug("Search for location :" + location);
		this.enterText(searchLocationField, location);
		try {
			for (WebElement e : primaryLocations) {
				if (e.getText().equals(location) && regions.get(primaryLocations.indexOf(e)).getText().equals(nation)) {
					e.click();
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Encountered Null pointer exception");
			e.printStackTrace();
		}
	}

	/**
	 * Select the date range
	 * 
	 * @param fromDate
	 * @param toDate
	 */
	public void selectDateRange(String fromDate, String toDate) {
		LOG.debug("Enter Start date as :" + fromDate);
		for (WebElement element : dateList) {
			if (this.getAttribute(element, "datetime").equals(fromDate)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
				break;
			}
		}
		LOG.debug("Enter End date as :" + toDate);
		for (WebElement element : dateList) {
			if (this.getAttribute(element, "datetime").equals(toDate)) {
				element.click();
				break;
			}
		}
		System.out.println();
	}

	/**
	 * Enter number of adults
	 * 
	 * @param noOfAdults
	 */
	public void enterNumberOfAdults(String noOfAdults) {
		LOG.debug("Enter number of adults as :" + noOfAdults);
		((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", adultField);
		this.enterText(adultField, noOfAdults);
		this.clickElement(applyButton);
	}

	/**
	 * Click Search Button
	 */
	public void clickSearchButton() {
		LOG.debug("Click Search Button");
		this.clickElement(searchButton);
	}
}
