package com.trivago.automationframework.common;

import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trivago.automationframework.interfaces.DriverInterface;


public class AbstractWebdriverPage {
	private DriverInterface driverInterface;
	protected WebDriver driver;
	protected WebDriverWait wait;

	public AbstractWebdriverPage(DriverInterface driverInterface) {

		this.driverInterface = driverInterface;
		this.driver = (WebDriver) this.driverInterface.getDriver();
		this.wait = new WebDriverWait(driver, 10);
	}

	/**
	 * @return {@link DriverInterface} which was initialized in the constructor.
	 */
	public DriverInterface getDriverInterface() {

		return this.driverInterface;
	}
	
	/**
	 * Get current page url
	 * 
	 * @return String
	 */
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Clicks on the element in the argument.
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		element.click();
	}
	
	/**
	 * Gets the text from the element.
	 * 
	 * @param element
	 * @return textFromTheElement
	 */
	public String getText(WebElement element) {
		return element.getText();
	}
	
	/**
	 * Enters the keys in the argument by overriding the existing value in the
	 * element.
	 * 
	 * @param element
	 * @param keysToSend
	 * 
	 */
	public void enterText(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	
	/**
	 * Checks if an element is present in a page.
	 * 
	 * @param element
	 * @return {@link Boolean} status if the element is displayed.
	 */
	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Select by text from Dropdown
	 * 
	 * @param dropdown
	 * @param text
	 */
	public void selectDropdownByVisibleText(WebElement dropdown, String text) {
		Select DropdownElement = new Select(dropdown);
		DropdownElement.selectByVisibleText(text);
	}
	
	/**
	 * Performs MouseHover action on a particular field.
	 * 
	 * @param element
	 */
	public void performMouseHover(WebElement element) {
		Actions actions = new Actions((WebDriver) this.driverInterface.getDriver());
		actions.moveToElement(element).build().perform();
	}
	
	/**
	 * Gets the text attribute value of the element.
	 * 
	 * @param element
	 * @param attribute
	 * @return textFromTheElement
	 */
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	/**
	 * Clears the already existing content at an webelement such as a text box.
	 * 
	 * @param element
	 */
	public void clear(WebElement element) {
		element.clear();
	}
	
	/**
	 * Gives current page title
	 * 
	 * @param element
	 */
	public String getPageTitle() {
		String pageTitle = driver.getTitle().trim();
		return pageTitle;
	}
	
	/**
	 * Returns the handles for all the available browser tabs
	 * 
	 * @return {@link ArrayList}
	 */
	public ArrayList<String> getTabs() {
		ArrayList<String> tabs = new ArrayList<String>(((WebDriver) this.driverInterface.getDriver()).getWindowHandles());
		return tabs;
	}

	/**
	 * Switches between open browser tabs
	 * 
	 * @param tabs  {@link ArrayList}: List of open browser tabs
	 * @param index {@link int}: Index of browser tab to switch to. Starts from
	 *              zero.
	 */
	public void switchToBrowserTab(ArrayList<String> tabs, int index) {
		((WebDriver) this.driverInterface.getDriver()).switchTo().window(tabs.get(index));
	}
	
	/**
	 * Select Value from Dropdown
	 * 
	 * @param dropdown
	 * @param value
	 */
	public void selectDropdownValue(WebElement dropdown, String value) {
		Select dropdownElement = new Select(dropdown);
		dropdownElement.selectByValue(value);
	}
	
	/**
	 * Closes currently active tab
	 */
	public void closeTab() {
		((WebDriver) this.driverInterface.getDriver()).close();
	}
	
	/**
	 * Switches back from frame to default window
	 */
	public void switchToDefaultContent() {
		((WebDriver) this.driverInterface.getDriver()).switchTo().defaultContent();
	}
}
