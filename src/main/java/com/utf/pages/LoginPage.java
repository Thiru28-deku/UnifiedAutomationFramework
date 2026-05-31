package com.utf.pages;

import org.openqa.selenium.By;
import com.utf.enums.WaitStrategy;

public class LoginPage extends BasePage {

	private final By emailField = By.xpath("//input[@data-qa='login-email']");
	private final By passwordField = By.xpath("//input[@data-qa='login-password']");
	private final By loginButton = By.xpath("//button[@data-qa='login-button']");
	private final By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");

	public LoginPage enterEmail(String email) {
		sendkeys(emailField, email, WaitStrategy.VISIBLE, "Email Field");
		return this;
	}

	public LoginPage enterPassword(String password) {
		sendkeys(passwordField, password, WaitStrategy.VISIBLE, "Password Field");
		return this;
	}

	public HomePage clickLogin() {
		click(loginButton, WaitStrategy.CLICKABLE, "Login Button");
		return new HomePage();
	}

	public LoginPage clickLoginExpectingFailure() {
		click(loginButton, WaitStrategy.CLICKABLE, "Login Button");
		return this;
	}

	public String getErrorMessage() {
		return getText(errorMessage, WaitStrategy.VISIBLE, "Error Message");
	}

	private final By signupNameField = By.xpath("//input[@data-qa='signup-name']");

	public SignupPage goToSignup() {
		return new SignupPage();
	}
}