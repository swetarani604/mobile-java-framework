package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductResultElements {
    public ProductResultElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text, \"Results for\")]")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement resultText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'ProductName')]")
    @iOSXCUITFindBy(xpath = "")
    public List<MobileElement> productName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(xpath = "")
    public List<MobileElement> productPrice;

}