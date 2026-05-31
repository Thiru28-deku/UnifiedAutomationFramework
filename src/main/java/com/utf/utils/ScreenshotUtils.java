package com.utf.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utf.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {
		
	}
	
	public static String getBase64Img() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
