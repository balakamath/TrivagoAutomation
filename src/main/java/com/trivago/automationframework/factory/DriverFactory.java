package com.trivago.automationframework.factory;

import org.apache.log4j.Logger;

import com.trivago.automationframework.constants.Constants;
import com.trivago.automationframework.drivers.ChromeDriverLocal;
import com.trivago.automationframework.interfaces.DriverInterface;

/**
 * Creates driver instance and returns the existing instance.
 */
public class DriverFactory {

	private final static Logger LOG = Logger.getLogger(DriverFactory.class);
	private String currentDriver;
	private static DriverFactory instance;
	private DriverInterface driverInterface;

	/**
	 * Singleton {@link DriverFactory} constructor that returns the relevant
	 * {@link DriverInterface} as per the driverName specified in the argument.
	 * 
	 * @param driverName
	 */
	public DriverFactory(String driverName) {
		LOG.debug("Launching the driver : " + driverName.toUpperCase());
		this.currentDriver = driverName;

		switch (this.currentDriver.toLowerCase()) {

		case Constants.DriverNames.CHROME:
			this.driverInterface = new ChromeDriverLocal();
			break;

		default:
			LOG.error(String.format("ERROR : Support for the %s driver is not available", driverName));
			break;
		}
	}

	public static synchronized DriverFactory getInstance(String driverName) {
		instance = new DriverFactory(driverName);
		return instance;
	}

	public DriverInterface getDriverInterface() {
		return this.driverInterface;
	}

}
