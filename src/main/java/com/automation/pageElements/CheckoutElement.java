package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutElement {
    public CheckoutElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/cv_best_slot")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement deliverySlotBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/fp_subscriptionStatus")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement fpBannertext;

    @AndroidFindBy(accessibility = "Close slot selection screen")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement closeBtn;

    @AndroidFindBy(accessibility = "Save changes heading")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement saveChangesPopUp;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/primaryButton")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement saveChangesYesbtn;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement DeliveryTimeIsUnavailable;

    @AndroidFindBy(accessibility = "")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement DeliveryTimeIsUnavailableOkayBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/button_text")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement placeOrderBtn;

}