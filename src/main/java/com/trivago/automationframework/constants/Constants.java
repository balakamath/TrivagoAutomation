package com.trivago.automationframework.constants;

import java.util.Random;

/**
 * @author balachandrakamath
 * 
 * This class contains all the constants used across project
 *
 */
public class Constants {

	public static final class DriverNames {

		private DriverNames() {
		}

		public static final String CHROME = "chrome";
	}
	
	public static final class PageUrls {

		private PageUrls() {
		}

		public static final String TRIVAGO_MAIN_PAGE = "https://www.trivago.in/";
	}

	public static final class Headers {

		private Headers() {
		}

		public static final String DONT_HAVE_ACCOUNT = "Don't have an account yet?";
		public static final String CREATE_ACCOUNT = "Create your account";
	}
	
	public static final class Credentials {
		static Random rand = new Random();

		private Credentials() {
		}

		public static final String EMAIL_ID = rand.nextInt(1000) + "trivagotest" + rand.nextInt(1000)+"@gmail.com";
		public static final String PASSWORD = "@Trivago456789";
	}
	
	public static final class HelpAndSupportOptions {

		private HelpAndSupportOptions() {
		}

		public static final String FOUND_AN_ERROR_WHILE_USING_TRIVAGO = "I found an error while using trivago";
	}
	
	public static final class errorFormEntries {

		private errorFormEntries() {
		}

		public static final String INCORRECT_HOTEL = "Incorrect hotel";
		public static final String SUBJECT = "Subject for the Error";
		public static final String DESCRIPTION = "DEscription of the error";
		public static final String HOTEL_NAME = "Taj Vivanta";
		public static final String BOOKING_SITE = "www.taj.com";
	}
	
	public static final class Messages {

		private Messages() {
		}

		public static final String SUCCESS_MESSAGE = "Your message was sent successfully!";
		
	}
	
	public static final class Location {

		private Location() {
		}

		public static final String GOA = "Goa";
		public static final String REGION_INDIA = "Region - India";
	}
	
	public static final class HotelNames {

		private HotelNames() {
		}

		public static final String AZAYA_BEACH_RESORT_GOA = "Azaya Beach Resort Goa";
	}
	
	public static final class finalDetails {

		private finalDetails() {
		}

		public static final String FIRST_NAME = "FirstName";
		public static final String LAST_NAME = "LastName";
		public static final String EMAIL_ID = "trivagotest456@gmail.com";
		
	}
}
