package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartElements {
    public CartElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tv_cart_count")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement cartIcon;

    @AndroidFindBy(accessibility = "Checkout, button")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement checkoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cartBasketProductNameLabel\")]")
    @iOSXCUITFindBy(xpath = "")
    public List<MobileElement> cartProducts;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tvDftaTitle")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement forgetSomethingTxt;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/checkoutButton")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement continueToCheckoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Remove\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Remove')]\"")
    public List<MobileElement> removeBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/ctaLabel")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement cartEmptyText;

}