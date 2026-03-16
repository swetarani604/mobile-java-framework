package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsElement {
    public ProductDetailsElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"$\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS '$'")
    public WebElement productPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"pdpHeaderProductName\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name CONTAINS 'Product'`]")
    public WebElement productName;

    @AndroidFindBy(accessibility  = "Details heading button expanded double tap to collapse")
    @iOSXCUITFindBy(accessibility = "productDetailsSection")
    public WebElement productDetails;

    @AndroidFindBy(xpath = "//*[@text=\"Add to cart\"]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Add'`]")
    public WebElement addToCartBtn;

}