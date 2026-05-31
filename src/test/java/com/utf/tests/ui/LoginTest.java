package com.utf.tests.ui;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.utf.annotation.FrameworkAnnotation;
import com.utf.base.BaseTest;
import com.utf.enums.CategoryType;
import com.utf.pages.LoginPage;
import com.utf.utils.DataProviderUtils;

public final class LoginTest extends BaseTest {

    private LoginTest() {
    }

    @FrameworkAnnotation(authors = {"Thiru"}, categories = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void validLoginTest(Map<String, String> data) {
        boolean isLoggedIn = new LoginPage()
            .enterEmail(data.get("email"))
            .enterPassword(data.get("password"))
            .clickLogin()
            .isLoggedIn();
        Assertions.assertThat(isLoggedIn)
            .as("User should be logged in successfully")
            .isTrue();
    }

    @FrameworkAnnotation(authors = {"Thiru"}, categories = {CategoryType.REGRESSION})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void invalidLoginTest(Map<String, String> data) {
        String errorMsg = new LoginPage()
            .enterEmail(data.get("email"))
            .enterPassword(data.get("password"))
            .clickLoginExpectingFailure()
            .getErrorMessage();
        Assertions.assertThat(errorMsg)
            .as("Error message should appear for invalid credentials")
            .isEqualTo("Your email or password is incorrect!");
    }
}