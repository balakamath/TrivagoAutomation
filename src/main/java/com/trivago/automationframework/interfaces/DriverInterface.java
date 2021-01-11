package com.trivago.automationframework.interfaces;

/**
 * Driver {@code Interface}
 *
 */
public interface DriverInterface {

	/**
	 * @return {@link Object} which contains a driver as per the browser chosen.
	 */
	Object getDriver();

	/**
	 * Closes the driver that has been created.
	 */
	void closeDriver();

}
