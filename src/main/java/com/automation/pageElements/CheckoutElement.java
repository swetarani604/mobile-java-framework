package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutElement {
    public CheckoutElement(AppiumDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/cv_best_slot")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'slot'`]")
    public WebElement deliverySlotBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/fp_subscriptionStatus")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'FreshPass'")
    public WebElement fpBannertext;

    @AndroidFindBy(accessibility = "Close slot selection screen")
    @iOSXCUITFindBy(accessibility = "closeSlotSelection")
    public WebElement closeBtn;

    @AndroidFindBy(accessibility = "Save changes heading")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS 'Save changes'`]")
    public WebElement saveChangesPopUp;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/primaryButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Yes'")
    public WebElement saveChangesYesbtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/button_text")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Place Order'`]")
    public WebElement placeOrderBtn;

}