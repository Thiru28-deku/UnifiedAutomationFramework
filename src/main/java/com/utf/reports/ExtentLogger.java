package com.utf.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;
import com.utf.utils.ScreenshotUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {
		
	}

	public static void pass(String message) {
		ExtentManager.getExtendTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentManager.getExtendTest().fail(message);
	}
	
	public static void skip(String message) {
		ExtentManager.getExtendTest().skip(message);
	}
	
	public static void pass(String message,boolean isScreenshotNeeded) throws Exception {
		if(ConfigUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtendTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String
					(ScreenshotUtils.getBase64Img()).build());
		}
		else {
			pass(message);
		}
	}
	public static void fail(String message,boolean isScreenshotNeeded) throws Exception {
		if(ConfigUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtendTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String
					(ScreenshotUtils.getBase64Img()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skip(String message,boolean isScreenshotNeeded) throws Exception {
		if(ConfigUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtentManager.getExtendTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String
					(ScreenshotUtils.getBase64Img()).build());
		}
		else {
			skip(message);
		}
	}
	
	
}
