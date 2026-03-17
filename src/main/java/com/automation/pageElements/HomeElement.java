package com.automation.pageElements;

import com.automation.driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeElement {
    public HomeElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/clHeroCanvasBanner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name CONTAINS 'banner'`]")
    public WebElement bannerSectionAtTop;

    @AndroidFindBy(id="com.safeway.client.android.albertsons:id/sv_global")
    @iOSXCUITFindBy(accessibility = "searchBar")
    public WebElement searchBar;

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSearchField'")
    public WebElement searchEntertxt;

    public By getProductLocator(String productName) {

        AppiumDriver driver = DriverManager.getDriver();

        String platform = driver.getCapabilities()
                .getCapability("platformName")
                .toString()
                .toLowerCase();
        if (platform.contains("android")) {
            return AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", productName));
        } else {
            return AppiumBy.iOSNsPredicateString(String.format("name == '%s'", productName));
        }
    }

}
