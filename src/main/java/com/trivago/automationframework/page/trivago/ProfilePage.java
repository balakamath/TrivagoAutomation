package com.trivago.automationframework.page.trivago;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.interfaces.DriverInterface;

public class ProfilePage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//*[@id='user-text']//span[@data-di-mask='true']")
	private static WebElement emailId;
	
	@FindBy(xpath = "//a[text()='Account settings']")
	private static WebElement accountSettingsLink;
	
	@FindBy(xpath = "//h2[text()='Account settings']")
	private static WebElement accountSettingsHeader;
	
	@FindBy(xpath = "//*[@id='error-topics']")
	private static WebElement selectErrorTopics;
	
	@FindBy(xpath = "//*[@id='support-center']//h3")
	private static WebElement selectedErrorTopic;
	
	@FindBy(xpath = "//*[@id='error-encounter']")
	private static WebElement selectErrorType;
	
	@FindBy(xpath = "//*[@id='subject']")
	private static WebElement subjectTextField;
	
	@FindBy(xpath = "//*[@id='description']")
	private static WebElement descriptionTextField;
	
	@FindBy(xpath = "//*[@id='hotel-name']")
	private static WebElement hotelNameTextField;
	
	@FindBy(xpath = "//*[@id='booking-site']")
	private static WebElement bookingSiteTextField;
	
	@FindBy(xpath = "//*[@id='checkin-date']")
	private static WebElement dateField;
	
	@FindBy(xpath = "//*[@id='fileInput']")
	private static WebElement fileInput;
	
	@FindBy(xpath = "//button[contains(@class,'submit')]")
	private static WebElement sendMessageButton;
	
	@FindBy(xpath = "//*[@id='support-center']//h4")
	private static WebElement successMessage;
	
	@FindBy(xpath = "//button[text()='Log out']")
	private static WebElement logoutButton;
	
	private final static Logger LOG = Logger.getLogger(ProfilePage.class);

	public ProfilePage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}
	
	/**
	 * Return Email id from profile page
	 * 
	 * @return String :  Email Id
	 */
	public String getEmailId() {
		LOG.debug("Returns email Id of profile page");
		return this.getText(emailId);
	}
	
	/**
	 * Click/Navigate to Account setting section
	 */
	public void navigateToAccountSettings() {
		LOG.debug("Mouse Hover on Profile dropdown");
		this.performMouseHover(emailId);
		LOG.debug("Click on Account settings button");
		this.clickElement(accountSettingsLink);
	}
	
	/**
	 * Returns true if Account settings header is displayed else false
	 */
	public boolean isAccountSettingsHeaderDisplayed() {
		LOG.debug("Returns email Id of profile page");
		return this.isDisplayed(accountSettingsHeader);
	}
	
	/**
	 * Select errorTopic as error Topic from dropdown
	 * 
	 * @param errorTopic : Error Topic as displayed in dropdown
	 */
	public void selectErrorTopics(String errorTopic) {
		LOG.debug("Select " + errorTopic + " as error topic");
		this.selectDropdownByVisibleText(selectErrorTopics, errorTopic);
	}
	
	/**
	 * Returns text of header of selected error topic
	 * 
	 * @return String : Selected error topic
	 */
	public String getHeaderOfSelectedTopic() {
		LOG.debug("Returns text of the header of selected topic");
		return this.getText(selectedErrorTopic);
	}
	
	/**
	 * Fill ups the error form 
	 * 
	 * @param errorType
	 * @param subject
	 * @param Description
	 * @param hotelName
	 * @param bookingSite
	 * @param checkingDate
	 */
	public void fillUpErrorForm(String errorType, String subject, String Description, String hotelName, String bookingSite, String checkingDate) {
		String location  = System.getProperty("user.dir");
		LOG.debug("Select error type as :" + errorType);
		this.selectDropdownByVisibleText(selectErrorType, errorType);
		LOG.debug("Enter Subject as :" + subject);
		this.enterText(subjectTextField, subject);
		LOG.debug("Enter Description as :" + Description);
		this.enterText(descriptionTextField, Description);
		LOG.debug("Enter Hotel Name as :" + hotelName);
		this.enterText(hotelNameTextField, hotelName);
		LOG.debug("Enter Booking Site as :" + bookingSite);
		this.enterText(bookingSiteTextField, bookingSite);
		LOG.debug("Enter date as :" + checkingDate);
		((JavascriptExecutor)driver).executeScript ("document.getElementById('checkin-date').removeAttribute('readonly',0);");
		this.enterText(dateField, checkingDate);
		LOG.debug("Upload the File");
		this.enterText(fileInput, location + File.separator + "src" +File.separator+"test"+File.separator+"resources"+File.separator+ "Testing.txt");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.debug("Click Send Message button");
		this.clickElement(sendMessageButton);
	}
	
	/**
	 * Return success message after error is submitted
	 * 
	 * @return String : Success message
	 */
	public String getSuccessMessage() {
		LOG.debug("Returns Success Message after filling up the form");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.getText(successMessage);
	}
	
	/**
	 * Click logout button
	 */
	public void clickLogoutButton() {
		LOG.debug("Mouse Hover on Profile dropdown");
		this.performMouseHover(emailId);
		LOG.debug("Click on logout button");
		this.clickElement(logoutButton);
	}
}
