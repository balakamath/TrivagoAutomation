package com.trivago.automationframework.page.trivago;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * 
 * This Page contains locators and helper methods of Create Account Page
 *
 */
public class CreateAccountPage extends AbstractWebdriverPage {

	@FindBy(xpath = "//*[@class='content-body']/h1[@class='box__headline js_headLine']")
	private static WebElement createAccountHeader;
	
	@FindBy(xpath = "//*[@id='register_email']")
	private static WebElement emailIdTextField;
	
	@FindBy(xpath = "//*[@id='register_password']")
	private static WebElement passwordTextField;
	
	@FindBy(xpath = "//*[@id='register_email_submit']")
	private static WebElement registerButton;

	private final static Logger LOG = Logger.getLogger(CreateAccountPage.class);

	public CreateAccountPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}

	/**
	 * Returns text of the header (h1) of the Create account page
	 * 
	 * @return String : The text of the header(h2)
	 */
	public String getCreateAccountHeaderText() {
		LOG.debug("Return the text of new account");
		return this.getText(createAccountHeader);
	}

	/**
	 * Input emailId and password and clicks on Register button
	 * 
	 * @param emailId
	 * @param password
	 */
	public void createAccount(String emailId, String password) {
		LOG.debug("Enter EmailId");
		this.enterText(emailIdTextField, emailId);
		LOG.debug("Enter Password");
		this.enterText(passwordTextField, password);
		LOG.debug("Click Register button");
		this.clickElement(registerButton);
	}
}
