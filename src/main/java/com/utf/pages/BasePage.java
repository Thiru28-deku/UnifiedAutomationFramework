package com.utf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utf.driver.DriverManager;
import com.utf.enums.WaitStrategy;
import com.utf.factory.ExplicitWaitFactory;
import com.utf.reports.ExtentLogger;

public  class BasePage {

	protected void click(By by, WaitStrategy waitStrategy,String elementName)  {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementName+" is clicked successfully",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendkeys(By by,String value,WaitStrategy waitstrategy,String elementName)  {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered successfully in "+elementName,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
	    WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
	    String text = element.getText();
	    try {
	        ExtentLogger.pass(elementName + " text is: " + text, false);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to log getText action: " + elementName, e);
	    }
	    return text;
	}

	protected boolean isDisplayed(By by, WaitStrategy waitStrategy) {
	    try {
	        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
}


