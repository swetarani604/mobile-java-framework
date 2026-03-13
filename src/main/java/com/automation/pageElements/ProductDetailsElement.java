package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetailsElement {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement productPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"pdpHeaderProductName\")]")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement productName;

    @AndroidFindBy(accessibility  = "Details heading button expanded double tap to collapse")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement productDetails;

    @AndroidFindBy(xpath = "//*[@text=\"Add to cart\"]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement addToCartBtn;

}