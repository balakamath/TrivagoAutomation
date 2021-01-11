package com.trivago.automationframework.page.trivago;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trivago.automationframework.common.AbstractWebdriverPage;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * This page contains locators and helper functions of Hotel booking site
 *
 */
public class HotelBookingPage extends AbstractWebdriverPage{
	
	@FindBy(xpath = "//*[@id='hp_hotel_name']")
	private static WebElement hotelNameHeader;
	
	@FindBy(xpath = "//*[@id='hprt_nos_select_258891808_279440628_2_25_0']")
	private static WebElement selectVillaEssenceRoomKingBed;
	
	@FindBy(xpath = "//button[contains(text(),'reserve')]")
	private static WebElement reserveButton;

	private final static Logger LOG = Logger.getLogger(MainPage.class);

	public HotelBookingPage(DriverInterface driverInterface) {
		super(driverInterface);
		PageFactory.initElements((WebDriver) driverInterface.getDriver(), this);
	}

	/**
	 * Returns Hotel Name
	 * 
	 * @return String : Hotel Name
	 */
	public String getHotelName() {
		LOG.debug("Returns Hotel Name");
		return this.getText(hotelNameHeader);
	}
	
	/**
	 * Selects number of villas for Essence Room King bed
	 * 
	 * @param noOfVillas
	 */
	public void selectVillaForEssenceRoomKingBed(String noOfVillas) {
		LOG.debug("Select number of villas ");
		this.performMouseHover(selectVillaEssenceRoomKingBed);
		this.selectDropdownValue(selectVillaEssenceRoomKingBed, noOfVillas);
		this.performMouseHover(reserveButton);
		this.clickElement(reserveButton);
	}
}
