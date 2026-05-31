package com.utf.pages;

import org.openqa.selenium.By;
import com.utf.enums.WaitStrategy;

public class HomePage extends BasePage {

    private final By loggedInUser = 
        By.xpath("//a[contains(text(),' Logged in as')]");
    private final By deleteAccountLink = 
        By.xpath("//a[@href='/delete_account']");
    private final By logoutLink = 
        By.xpath("//a[@href='/logout']");
    private final By accountDeletedMsg = 
        By.xpath("//b[text()='Account Deleted!']");

    public boolean isLoggedIn() {
        return isDisplayed(loggedInUser, WaitStrategy.VISIBLE);
    }

    public String getLoggedInUsername() {
        return getText(loggedInUser, WaitStrategy.VISIBLE, "Logged In User");
    }

    public HomePage clickDeleteAccount() {
        click(deleteAccountLink, WaitStrategy.CLICKABLE, "Delete Account");
        return this;
    }

    public HomePage clickLogout() {
        click(logoutLink, WaitStrategy.CLICKABLE, "Logout");
        return this;
    }

    public boolean isAccountDeleted() {
        return isDisplayed(accountDeletedMsg, WaitStrategy.VISIBLE);
    }
}