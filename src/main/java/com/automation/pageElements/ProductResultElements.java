package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class ProductResultElements {

    @AndroidFindBy(xpath = "//*[contains(@text, \"Results for\")]")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement resultText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'ProductName')]")
    @iOSXCUITFindBy(xpath = "")
    public static List<MobileElement> productName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(xpath = "")
    public static List<MobileElement> productPrice;

}