package com.trivago.automationframework.factory;

import com.trivago.automationframework.interfaces.DriverInterface;
import com.trivago.automationframework.page.trivago.AllHotelsPage;
import com.trivago.automationframework.page.trivago.BookingSitesPage;
import com.trivago.automationframework.page.trivago.CreateAccountPage;
import com.trivago.automationframework.page.trivago.FinalBookingPage;
import com.trivago.automationframework.page.trivago.HotelBookingPage;
import com.trivago.automationframework.page.trivago.LoginPage;
import com.trivago.automationframework.page.trivago.MainPage;
import com.trivago.automationframework.page.trivago.ProfilePage;

public class TrivagoPageFactory {

	private final DriverInterface driverInterface;

	public TrivagoPageFactory(DriverInterface driverInterface) {
		this.driverInterface = driverInterface;
	}

	public MainPage getMainPage() {
		return new MainPage(this.driverInterface);
	}

	public LoginPage getLoginPage() {
		return new LoginPage(this.driverInterface);
	}
	
	public CreateAccountPage getCreateAccountPage() {
		return new CreateAccountPage(this.driverInterface);
	}
	
	public ProfilePage getProfilePage() {
		return new ProfilePage(this.driverInterface);
	}
	
	public AllHotelsPage getAllHotelsPage() {
		return new AllHotelsPage(this.driverInterface);
	}
	
	public BookingSitesPage getBookingSitesPage() {
		return new BookingSitesPage(this.driverInterface);
	}
	
	public HotelBookingPage getHotelBookingPage() {
		return new HotelBookingPage(this.driverInterface);
	}
	
	public FinalBookingPage getFinalBookingPage() {
		return new FinalBookingPage(this.driverInterface);
	}
}
