package com.utf.pages;

import org.openqa.selenium.By;
import com.utf.enums.WaitStrategy;

public class SignupPage extends BasePage {

    private final By nameField = 
        By.xpath("//input[@data-qa='signup-name']");
    private final By emailField = 
        By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = 
        By.xpath("//button[@data-qa='signup-button']");
    private final By passwordField = 
        By.xpath("//input[@data-qa='password']");
    private final By firstNameField = 
        By.xpath("//input[@data-qa='first_name']");
    private final By lastNameField = 
        By.xpath("//input[@data-qa='last_name']");
    private final By addressField = 
        By.xpath("//input[@data-qa='address']");
    private final By countryDropdown = 
        By.xpath("//select[@data-qa='country']");
    private final By stateField = 
        By.xpath("//input[@data-qa='state']");
    private final By cityField = 
        By.xpath("//input[@data-qa='city']");
    private final By zipcodeField = 
        By.xpath("//input[@data-qa='zipcode']");
    private final By mobileField = 
        By.xpath("//input[@data-qa='mobile_number']");
    private final By createAccountButton = 
        By.xpath("//button[@data-qa='create-account']");
    private final By accountCreatedMsg = 
        By.xpath("//b[text()='Account Created!']");

    public SignupPage enterName(String name) {
        sendkeys(nameField, name, WaitStrategy.VISIBLE, "Name Field");
        return this;
    }

    public SignupPage enterEmail(String email) {
        sendkeys(emailField, email, WaitStrategy.VISIBLE, "Signup Email Field");
        return this;
    }

    public SignupPage clickSignup() {
        click(signupButton, WaitStrategy.CLICKABLE, "Signup Button");
        return this;
    }

    public SignupPage enterPassword(String password) {
        sendkeys(passwordField, password, WaitStrategy.VISIBLE, "Password Field");
        return this;
    }

    public SignupPage enterFirstName(String firstName) {
        sendkeys(firstNameField, firstName, WaitStrategy.VISIBLE, "First Name Field");
        return this;
    }

    public SignupPage enterLastName(String lastName) {
        sendkeys(lastNameField, lastName, WaitStrategy.VISIBLE, "Last Name Field");
        return this;
    }

    public SignupPage enterAddress(String address) {
        sendkeys(addressField, address, WaitStrategy.VISIBLE, "Address Field");
        return this;
    }

    public SignupPage enterState(String state) {
        sendkeys(stateField, state, WaitStrategy.VISIBLE, "State Field");
        return this;
    }

    public SignupPage enterCity(String city) {
        sendkeys(cityField, city, WaitStrategy.VISIBLE, "City Field");
        return this;
    }

    public SignupPage enterZipcode(String zipcode) {
        sendkeys(zipcodeField, zipcode, WaitStrategy.VISIBLE, "Zipcode Field");
        return this;
    }

    public SignupPage enterMobile(String mobile) {
        sendkeys(mobileField, mobile, WaitStrategy.VISIBLE, "Mobile Field");
        return this;
    }

    public SignupPage clickCreateAccount() {
        click(createAccountButton, WaitStrategy.CLICKABLE, "Create Account Button");
        return this;
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedMsg, WaitStrategy.VISIBLE);
    }
}