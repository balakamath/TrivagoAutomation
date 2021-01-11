package com.trivago.automationframework.factory;

import com.trivago.automationframework.utils.JavaUtils;

public class UtilityFactory {
	
	private static JavaUtils javaUtils;

	/**
	 * @return {@link JavaUtils} instance to call any api utility available in it.
	 */
	public static JavaUtils getJavaUtils() {

		if (javaUtils == null) {
			javaUtils = new JavaUtils();
		}
		return javaUtils;
	}
}
