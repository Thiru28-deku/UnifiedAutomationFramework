package com.utf.reports;

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utf.constant.FrameworkConstant;
import com.utf.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReport() throws Exception {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportPath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("OrangeHRMTest Report");
			spark.config().setDocumentTitle("Thiru's Report");
		}
	}

	public static void flushReport() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}

		ExtentManager.unload();
		
		if (!GraphicsEnvironment.isHeadless()
	            && Desktop.isDesktopSupported()) {

	        Desktop.getDesktop()
	               .browse(new File(FrameworkConstant.getExtentReportPath()).toURI());
	    }

	}

	public static void createTest(String test) {
		ExtentManager.setExtendTest(extent.createTest(test));
	}
	
	public static void addAuthors(String[] authors) {
		for(String auth:authors) {
			ExtentManager.getExtendTest().assignAuthor(auth);
		}
	}
	
	public static void addCategories(CategoryType[] category) {
		for(CategoryType auth:category) {
			ExtentManager.getExtendTest().assignCategory(auth.toString());
		}
	}
}
