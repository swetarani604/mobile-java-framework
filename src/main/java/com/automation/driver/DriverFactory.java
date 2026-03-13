package com.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    public static AppiumDriver initializeDriver(String platform) {

        AppiumDriver driver = null;

        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            if (platform.equalsIgnoreCase("android")) {

                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "Samsung A34");
                caps.setCapability("platformVersion", "16");
                caps.setCapability("udid", "RZCW31RH0FW");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("appPackage", "com.safeway.client.android.albertsons");
                caps.setCapability("appActivity", "com.safeway.mcommerce.android.SplashScreen");
                caps.setCapability("noReset", true);

                driver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723/wd/hub"), caps);

            }

            else if (platform.equalsIgnoreCase("ios")) {

                caps.setCapability("platformName", "iOS");
                caps.setCapability("deviceName", "iPhone 14");
                caps.setCapability("automationName", "XCUITest");
                caps.setCapability("bundleId", "com.albertsons.ios");

                driver = new IOSDriver(
                        new URL("http://127.0.0.1:4723/wd/hub"), caps);
            }

            DriverManager.setDriver(driver);

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}
