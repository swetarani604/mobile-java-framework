package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductResultElements {
    public ProductResultElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text, \"Results for\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Results for'")
    public WebElement  resultText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'ProductName')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label CONTAINS 'Product'")
    public List<WebElement> productName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS '$'")
    public List<WebElement> productPrice;

}