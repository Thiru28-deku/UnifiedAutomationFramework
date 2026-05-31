package com.utf.constant;

import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;

public final class FrameworkConstant {

	// Private constructor to prevent instantiation of the constant class
	private FrameworkConstant() {

	}

	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";

	// Directory path for ChromeDriver in the project
	private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
	private static final String EDGEDRIVERPATH = RESOURCEPATH + "/executables/msedgedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "/Config/config.properties";
	private static final String JSONFILEPATH = RESOURCEPATH + "/Config/Configs.json";
	private static final int EXPLICITWAIT = 20;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String HRMTESTSHEET = "HRMTest";
	private static final String DATASHEET = "Data";
	private static final String EXCELFILEPATH = RESOURCEPATH + "/Excel/testdata.xlsx";
	private static String extentReportFilePath = "";
	private static final String AUTOMATIONEXERCISESHEET = "AutomationExercise";

	public static String getExtentReportPath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {
		if (ConfigUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		} else
			return EXTENTREPORTFOLDERPATH + "/index.html";
	}

	// Getter method to expose the ChromeDriverPath to other classes
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getJsonFilePath() {
		return JSONFILEPATH;
	}
	
	public static String getExcelFile() {
		return EXCELFILEPATH;
	}
	
	public static String getHRMTestSheet() {
		return HRMTESTSHEET;
	}
	
	public static String getDataSheet() {
		return DATASHEET;
	}

	public static String getEdgeDriverPath() {
		return EDGEDRIVERPATH;
	}
	
	public static String getAutomationExerciseSheet() {
	    return AUTOMATIONEXERCISESHEET;
	}
	

}
