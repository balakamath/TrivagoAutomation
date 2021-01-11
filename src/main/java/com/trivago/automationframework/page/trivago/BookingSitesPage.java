package com.trivago.automationframework.page.trivago;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * This page contains locators and methods of Booking Sites opened when clicked on View Deal of the hotels
 *
 */
public class BookingSitesPage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//*[@id='hotellist_inner']//a[@class='js-sr-hotel-link hotel_name_link url']/span[1]")
	private static List<WebElement> hotelNamesList;
	
	@FindBy(xpath = "//*[@id='hotellist_inner']//*[@class='bui-button__text' and contains(text(),'availability')]")
	private static List<WebElement> seeAvailabilityButtons;
	
	private final static Logger LOG = Logger.getLogger(MainPage.class);

	public BookingSitesPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}

	/**
	 * Switches the driver control to new tab with index
	 */
	public void switchControlToBookingSite() {
		LOG.debug("Switches the driver control to new tab with index");
		this.switchToBrowserTab(this.getTabs(), 1);
	}
	
	/**
	 * Returns true if hotelName found else false
	 * 
	 * @param hotelName
	 * @return boolean
	 */
	public boolean verifyHotelNameExists(String hotelName) {
		LOG.debug("Verifies whether " + hotelName + "Exists in hotels list page");
		try {
			for(WebElement element : hotelNamesList) {
				if(this.getText(element).equals(hotelName)) {
					return true;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Encountered Null pointer exception");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Clicks on the See Availability corresponding to hotelName
	 * 
	 * @param hotelName
	 */
	public void clickSeeAvailabilityOfHotel(String hotelName) {
		LOG.debug("Clicks on the View Deal corresponding to hotelName");
		try {
			for(WebElement element : hotelNamesList) {
				if(this.getText(element).equals(hotelName)) {
					this.clickElement(seeAvailabilityButtons.get(hotelNamesList.indexOf(element)));
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Encountered Null pointer exception");
			e.printStackTrace();
		}
	}
}
