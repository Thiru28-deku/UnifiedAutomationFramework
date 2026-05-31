package com.utf.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utf.constant.FrameworkConstant;
import com.utf.driver.DriverManager;
import com.utf.enums.WaitStrategy;

public class ExplicitWaitFactory {


	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if(waitStrategy==WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstant.getExplicitWait()))
			.until(ExpectedConditions.
					elementToBeClickable(by));

		}
		else if (waitStrategy==WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstant.getExplicitWait()))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy==WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstant.getExplicitWait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}

		return element;

	}
}
