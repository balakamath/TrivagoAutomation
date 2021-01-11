package com.trivago.automationframework.trivago;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.trivago.automationframework.constants.Constants.Credentials;
import com.trivago.automationframework.constants.Constants.Headers;
import com.trivago.automationframework.constants.Constants.HelpAndSupportOptions;
import com.trivago.automationframework.constants.Constants.HotelNames;
import com.trivago.automationframework.constants.Constants.Location;
import com.trivago.automationframework.constants.Constants.Messages;
import com.trivago.automationframework.constants.Constants.PageUrls;
import com.trivago.automationframework.constants.Constants.errorFormEntries;
import com.trivago.automationframework.constants.Constants.finalDetails;
import com.trivago.automationframework.factory.UtilityFactory;
import com.trivago.automationframework.trivago.BaseTest;

public class LoginTest extends BaseTest {

	private final static Logger LOG = Logger.getLogger(LoginTest.class);

	@Test
	public void requirementOne() {

		LOG.info("Validate whether in Main page");
		assertEquals(trivagoPageFactory.getMainPage().getCurrentPageUrl(), PageUrls.TRIVAGO_MAIN_PAGE, "URL mismatch. Acutal URl is :" + trivagoPageFactory.getMainPage().getCurrentPageUrl());

		LOG.info("Click on Login Button");
		trivagoPageFactory.getMainPage().clickLoginButton();

		LOG.info("Validate whether in Login Page");
		assertEquals(trivagoPageFactory.getLoginPage().getNewAccountHeaderText(), Headers.DONT_HAVE_ACCOUNT, "Header mismatch or not found");

		LOG.info("Click on Create an account Button");
		trivagoPageFactory.getLoginPage().clickCreateAccountButton();

		LOG.info("Validate whether in Create Account Page");
		assertEquals(trivagoPageFactory.getCreateAccountPage().getCreateAccountHeaderText(), Headers.CREATE_ACCOUNT, "Header mismatch or not found");

		LOG.info("Create account by providing emailId " + Credentials.EMAIL_ID + " and Password");
		trivagoPageFactory.getCreateAccountPage().createAccount(Credentials.EMAIL_ID, Credentials.PASSWORD);

		LOG.info("Validate whether account is successfully created");
		assertEquals(trivagoPageFactory.getProfilePage().getEmailId(), Credentials.EMAIL_ID, "Profile not created");

		LOG.info("Navigate to Account Settings");
		trivagoPageFactory.getProfilePage().navigateToAccountSettings();

		LOG.info("Validate whether Account settings section is displayed");
		assertTrue(trivagoPageFactory.getProfilePage().isAccountSettingsHeaderDisplayed(), "Account Settings is not present");

		LOG.info("Select " + HelpAndSupportOptions.FOUND_AN_ERROR_WHILE_USING_TRIVAGO + " from Help and Support section");
		trivagoPageFactory.getProfilePage().selectErrorTopics(HelpAndSupportOptions.FOUND_AN_ERROR_WHILE_USING_TRIVAGO);

		LOG.info("Validate whether " + HelpAndSupportOptions.FOUND_AN_ERROR_WHILE_USING_TRIVAGO + "option is selected");
		assertEquals(trivagoPageFactory.getProfilePage().getHeaderOfSelectedTopic(), HelpAndSupportOptions.FOUND_AN_ERROR_WHILE_USING_TRIVAGO);

		LOG.info("Fill Error form");
		trivagoPageFactory.getProfilePage().fillUpErrorForm(errorFormEntries.INCORRECT_HOTEL, errorFormEntries.SUBJECT, errorFormEntries.DESCRIPTION, errorFormEntries.HOTEL_NAME,
				errorFormEntries.BOOKING_SITE, "01-01-2021");
		
		UtilityFactory.getJavaUtils().sleep(5000);

		LOG.info("Validate Success Message");
		assertEquals(trivagoPageFactory.getProfilePage().getSuccessMessage(), Messages.SUCCESS_MESSAGE, "Success Message do not match");
		
		UtilityFactory.getJavaUtils().sleep(5000);
		
		LOG.info("Logout of the trivago account");
		trivagoPageFactory.getProfilePage().clickLogoutButton();
	}
	
	@Test
	public void requirementTwo() {
				
		LOG.info("Search " + Location.GOA + " " + Location.REGION_INDIA +" in search field");
		trivagoPageFactory.getMainPage().searchAndSelectLocation(Location.GOA, Location.REGION_INDIA);
		
		LOG.info("Select Date range");
		trivagoPageFactory.getMainPage().selectDateRange("2021-01-25","2021-01-27");
		
		LOG.info("Select 1 adults");
		trivagoPageFactory.getMainPage().enterNumberOfAdults("1");
		
		LOG.info("Click Search button");
		trivagoPageFactory.getMainPage().clickSearchButton();
		
		LOG.info("Validate Whether Hotels page");
		UtilityFactory.getJavaUtils().sleep(5000);
		assertTrue(trivagoPageFactory.getAllHotelsPage().getPageTitle().contains(Location.GOA), "Not in Goa page");
		
		UtilityFactory.getJavaUtils().sleep(5000);
		
		LOG.info("Verify Whether " + HotelNames.AZAYA_BEACH_RESORT_GOA + " is listed");
		assertTrue(trivagoPageFactory.getAllHotelsPage().verifyHotelNameExists(HotelNames.AZAYA_BEACH_RESORT_GOA), HotelNames.AZAYA_BEACH_RESORT_GOA + " Not Found");
		
		LOG.info("Click View deal for " + HotelNames.AZAYA_BEACH_RESORT_GOA);
		trivagoPageFactory.getAllHotelsPage().clickViewDealOfHotel(HotelNames.AZAYA_BEACH_RESORT_GOA);
		
		UtilityFactory.getJavaUtils().sleep(5000);
		
		LOG.info("Switch Control to new tab"); 
		trivagoPageFactory.getBookingSitesPage().switchControlToBookingSite();
		
		//Assuming Booking.com site is opened
		LOG.info("Search if " + HotelNames.AZAYA_BEACH_RESORT_GOA +" is present");
		assertTrue(trivagoPageFactory.getBookingSitesPage().verifyHotelNameExists(HotelNames.AZAYA_BEACH_RESORT_GOA), HotelNames.AZAYA_BEACH_RESORT_GOA + " Not Found");
		
		LOG.info("Click See availability for " + HotelNames.AZAYA_BEACH_RESORT_GOA);
		trivagoPageFactory.getBookingSitesPage().clickSeeAvailabilityOfHotel(HotelNames.AZAYA_BEACH_RESORT_GOA);
		
		UtilityFactory.getJavaUtils().sleep(5000);
		
		LOG.info("Check correct hotel selected " + HotelNames.AZAYA_BEACH_RESORT_GOA);
		assertTrue(trivagoPageFactory.getHotelBookingPage().getHotelName().contains(HotelNames.AZAYA_BEACH_RESORT_GOA),"Wrong hotel details displayed");
		
		UtilityFactory.getJavaUtils().sleep(8000);
		
		LOG.info("Selects number of Villas");
		trivagoPageFactory.getHotelBookingPage().selectVillaForEssenceRoomKingBed("1");
		
		UtilityFactory.getJavaUtils().sleep(5000);
		
		LOG.info("Enter Details and click reserve");
		trivagoPageFactory.getFinalBookingPage().fillUpDetails();
		
		UtilityFactory.getJavaUtils().sleep(5000);

		LOG.info("Verify whether in final details page");
		assertEquals(trivagoPageFactory.getFinalBookingPage().getEmailId(),finalDetails.EMAIL_ID,"Not in Final details page");
		
		LOG.info("Closes current tab and moves back to first tab");
		trivagoPageFactory.getFinalBookingPage().closeAndMovetab();
	}
}
