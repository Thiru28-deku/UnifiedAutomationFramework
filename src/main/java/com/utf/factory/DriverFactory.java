package com.utf.factory;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws Throwable {
        WebDriver driver = null;
        String runMode = ConfigUtils.get(ConfigProperties.RUNMODE);
        boolean isCI = System.getenv("CI") != null;

        if (browser.equalsIgnoreCase("Chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless=new");
                option.addArguments("--no-sandbox");
                option.addArguments("--disable-dev-shm-usage");
                option.addArguments("--window-size=1920,1080");
                option.setCapability("browserName", 
                    Browser.CHROME.toString().toLowerCase());
                driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/"), option);
            } else {
                ChromeOptions option = new ChromeOptions();
                if (isCI) {
                    option.addArguments("--headless=new");
                    option.addArguments("--no-sandbox");
                    option.addArguments("--disable-dev-shm-usage");
                    option.addArguments("--window-size=1920,1080");
                }
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(option);
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            if (runMode.equalsIgnoreCase("remote")) {
                EdgeOptions option = new EdgeOptions();
                option.setCapability("browserName", 
                    Browser.EDGE.toString().toLowerCase());
                driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/"), option);
            } else {
                EdgeOptions option = new EdgeOptions();
                if (isCI) {
                    option.addArguments("--headless=new");
                    option.addArguments("--no-sandbox");
                    option.addArguments("--disable-dev-shm-usage");
                    option.addArguments("--window-size=1920,1080");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(option);
            }
        }
        return driver;
    }
}