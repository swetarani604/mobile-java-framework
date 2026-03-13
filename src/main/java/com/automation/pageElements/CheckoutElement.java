package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CheckoutElement {

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/cv_best_slot")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement deliverySlotBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/fp_subscriptionStatus")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement fpBannertext;

    @AndroidFindBy(accessibility = "Close slot selection screen")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement closeBtn;

    @AndroidFindBy(accessibility = "Save changes heading")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement saveChangesPopUp;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/primaryButton")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement saveChangesYesbtn;

    @AndroidFindBy(id = "")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement DeliveryTimeIsUnavailable;

    @AndroidFindBy(accessibility = "")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement DeliveryTimeIsUnavailableOkayBtn;

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/button_text")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement placeOrderBtn;

}