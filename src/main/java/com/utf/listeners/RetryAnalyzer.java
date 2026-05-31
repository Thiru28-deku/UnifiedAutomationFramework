package com.utf.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;
		try {
			if (ConfigUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

}
