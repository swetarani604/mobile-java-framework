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

import java.util.List;

public class CartElements {
    public CartElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tv_cart_count")
    @iOSXCUITFindBy(accessibility  = "cartIcon")
    public WebElement cartIcon;

    @AndroidFindBy(accessibility = "Checkout, button")
    @iOSXCUITFindBy(accessibility = "checkoutBtn")
    public WebElement checkoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cartBasketProductNameLabel\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/**/XCUIElementTypeStaticText")
    public List<WebElement> cartProducts;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tvDftaTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Forgot'")
    public WebElement forgetSomethingTxt;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/checkoutButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue to Checkout'`]")
    public WebElement continueToCheckoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Remove\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Remove'")
    public List<WebElement> removeBtn;

    public By removeBtn() {

        AppiumDriver driver = DriverManager.getDriver();

        String platform = driver.getCapabilities()
                .getCapability("platformName")
                .toString()
                .toLowerCase();

        if (platform.contains("android")) {
            return AppiumBy.xpath("//*[contains(@text,\"Remove\")]/following-sibling::android.widget.Button");
        } else {
            return AppiumBy.iOSNsPredicateString("name CONTAINS 'cart'");
        }
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Your cart is')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'empty cart'")
    public WebElement cartEmptyText;

}