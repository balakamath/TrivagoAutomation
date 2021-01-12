package com.trivago.automationframework.page.trivago;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.factory.UtilityFactory;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * This Page contains alllocators and methods of All Hotels page
 *
 */
public class AllHotelsPage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//*[@class='item-link name__copytext name__copytext--small']")
	private static List<WebElement> hotelNamesList;
	
	@FindBy(xpath = "//*[@class='accommodation-list__button--534fc hoverState']")
	private static List<WebElement> viewDealButtons;
	
	@FindBy(xpath = "//*[@class='filter-item filter-item--select js-toolbar-hover-button']/strong[text()='Guest rating']")
	private static WebElement guestRatingButton;
	
	@FindBy(xpath = "//*[text()='Excellent']")
	private static WebElement excellentRating;
	
	private final static Logger LOG = Logger.getLogger(AllHotelsPage.class);

	public AllHotelsPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}
	
	/**
	 * Returns title of the page
	 * 
	 * @return String : Title of the page 
	 */
	public String getTitleOfPage() {
		LOG.debug("Returns title of the page");
		return this.getPageTitle();
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
	 * Clicks on the View Deal corresponding to hotelName
	 * 
	 * @param hotelName
	 */
	public void clickViewDealOfHotel(String hotelName) {
		LOG.debug("Clicks on the View Deal corresponding to hotelName");
		try {
			for(WebElement element : hotelNamesList) {
				if(this.getText(element).equals(hotelName)) {
					this.clickElement(viewDealButtons.get(hotelNamesList.indexOf(element)));
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Encountered Null pointer exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Clicks on 8.5 Excellent rating
	 * 
	 */
	public void filtersBasedOnRating() {
		LOG.debug("Clicks on the View Deal corresponding to hotelName");
		this.performMouseHover(guestRatingButton);
		UtilityFactory.getJavaUtils().sleep(5000);
		this.clickElement(excellentRating);
	}
}
