package com.trivago.automationframework.page.trivago;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.constants.Constants.finalDetails;
import com.trivago.automationframework.factory.UtilityFactory;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * This page contains loctaors and functions of final booking page
 *
 */
public class FinalBookingPage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//*[@id='firstname']")
	private static WebElement firstName;
	
	@FindBy(xpath = "//*[@id='lastname']")
	private static WebElement lastName;
	
	@FindBy(xpath = "//*[@id='email']")
	private static WebElement emailId;
	
	@FindBy(xpath = "//*[@id='email_confirm']")
	private static WebElement confirmEmailId;
	
	@FindBy(xpath = "//*[@name='book']")
	private static WebElement finalDetailsButton;
	
	@FindBy(xpath = "//*[@id='label_email']/div[2]")
	private static WebElement finalEmailId;
	
	@FindBy(xpath = "//*[@class='bui-modal__close']")
	private static WebElement popUpCloseButton;

	private final static Logger LOG = Logger.getLogger(MainPage.class);

	public FinalBookingPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}
	
	/**
	 * Fills up the reservation details
	 */
	public void fillUpDetails() {
		LOG.debug("Fill Up details");
		this.enterText(firstName, finalDetails.FIRST_NAME);
		this.enterText(lastName, finalDetails.LAST_NAME);
		this.enterText(emailId, finalDetails.EMAIL_ID);
		this.enterText(confirmEmailId, finalDetails.EMAIL_ID);
		this.clickElement(finalDetailsButton);
	}

	/**
	 * Closes the popup close button and returns email id used for booking
	 * 
	 * @return String : emailId
	 */
	public String getEmailId() {
		if(this.isDisplayed(popUpCloseButton)) {
			this.clickElement(popUpCloseButton);
			UtilityFactory.getJavaUtils().sleep(2000);
		}
		return this.getText(finalEmailId);
	}
	
	/**
	 * Closes current tab and moves back to first tab
	 */
	public void closeAndMovetab() {
		LOG.debug("Closes current tab and shifts control to first tab");
		this.closeTab();
		LOG.debug("Switches the driver control to new tab with index");
		this.switchToBrowserTab(this.getTabs(), 0);
	}
}
