package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class CartElements {

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tv_cart_count")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement cartIcon;

    @AndroidFindBy(accessibility = "Checkout, button")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement checkoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cartBasketProductNameLabel\")]")
    @iOSXCUITFindBy(xpath = "")
    public static List<MobileElement> cartProducts;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/tvDftaTitle")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement forgetSomethingTxt;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/checkoutButton")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement continueToCheckoutBtn;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Remove\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Remove')]\"")
    public List<MobileElement> removeBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/ctaLabel")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement cartEmptyText;

}