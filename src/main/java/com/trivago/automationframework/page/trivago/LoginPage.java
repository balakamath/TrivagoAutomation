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
 * This Page contains locators and helper methods of Login Page
 *
 */
public class LoginPage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//h2[@class='headline-below-box']")
	private static WebElement newAccountHeader;
	
	@FindBy(xpath = "//*[@id='login_signup_link']")
	private static WebElement createAnAccountButton;

	private final static Logger LOG = Logger.getLogger(LoginPage.class);

	public LoginPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}
	
	/**
	 * Return the text of the header 
	 * 
	 * @return String : The text of the header(h2)
	 */
	public String getNewAccountHeaderText() {
		LOG.debug("Return the text of new account");
		return this.getText(newAccountHeader);
	}
	
	/**
	 * Clicks on Create an account button in login page
	 */
	public void clickCreateAccountButton() {
		LOG.debug("Clicks on Create an account button in login page");
		this.clickElement(createAnAccountButton);
	}

}
