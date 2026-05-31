package com.utf.tests.ui;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.utf.annotation.FrameworkAnnotation;
import com.utf.base.BaseTest;
import com.utf.enums.CategoryType;
import com.utf.pages.LoginPage;
import com.utf.utils.DataProviderUtils;

public final class SignupTest extends BaseTest {

    private SignupTest() {
    }

    @FrameworkAnnotation(authors = {"Thiru"}, categories = {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void registerNewUserTest(Map<String, String> data) {
        boolean isAccountCreated = new LoginPage()
            .goToSignup()
            .enterName(data.get("name"))
            .enterEmail(data.get("email"))
            .clickSignup()
            .enterPassword(data.get("password"))
            .enterFirstName(data.get("firstname"))
            .enterLastName(data.get("lastname"))
            .enterAddress(data.get("address"))
            .enterState(data.get("state"))
            .enterCity(data.get("city"))
            .enterZipcode(data.get("zipcode"))
            .enterMobile(data.get("mobile"))
            .clickCreateAccount()
            .isAccountCreated();
        Assertions.assertThat(isAccountCreated)
            .as("Account should be created successfully")
            .isTrue();
    }
}