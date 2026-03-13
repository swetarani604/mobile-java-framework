package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsElement {
    public ProductDetailsElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement productPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"pdpHeaderProductName\")]")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement productName;

    @AndroidFindBy(accessibility  = "Details heading button expanded double tap to collapse")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement productDetails;

    @AndroidFindBy(xpath = "//*[@text=\"Add to cart\"]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement addToCartBtn;

}