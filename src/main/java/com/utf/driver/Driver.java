package com.utf.driver;

import java.util.Objects;

import com.utf.enums.ConfigProperties;
import com.utf.factory.DriverFactory;
import com.utf.utils.ConfigUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) throws Exception {
		
		if (Objects.isNull(DriverManager.getDriver())) {

			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (Throwable e) {
				throw new RuntimeException("Browser invocation is failed, please check the driver factory file");
			}
			DriverManager.getDriver().get(ConfigUtils.get(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();
			DriverManager.unload();

		}
	}

}
