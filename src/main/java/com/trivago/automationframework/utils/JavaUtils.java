package com.trivago.automationframework.utils;

import org.apache.log4j.Logger;

public class JavaUtils {

	private final static Logger LOG = Logger.getLogger(JavaUtils.class);

	/**
	 * Sleeps the thread for specified time.
	 * 
	 * @param timeInMillis
	 */
	public void sleep(long timeInMillis) {

		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LOG.error("ERROR : Could not execute sleep on this thread");
		}
	}
}
