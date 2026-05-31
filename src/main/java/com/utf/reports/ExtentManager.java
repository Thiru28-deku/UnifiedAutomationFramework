package com.utf.reports;
import com.aventstack.extentreports.ExtentTest;


public final class ExtentManager {
	
	private ExtentManager() {
		
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	 public static ExtentTest getExtendTest() {
		return extentTest.get();
	}
	
	 static void setExtendTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	 static void unload() {
		extentTest.remove();
	}
}
