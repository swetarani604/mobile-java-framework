package com.automation.pages;

import com.automation.utils.MobileActions;
import com.automation.pageElements.CheckoutElement;
import io.appium.java_client.AppiumDriver;

public class CheckoutPage {
    MobileActions actions;
    CheckoutElement checkoutElement;
    public CheckoutPage(AppiumDriver driver){

        actions = new MobileActions(driver);
        checkoutElement = new CheckoutElement(driver);
    }

    public void verifyDeliverySlots() {
        actions.assertElementVisible(checkoutElement.deliverySlotBtn);
        actions.clickElement(checkoutElement.deliverySlotBtn);

    }

    public void verifyFreshPassBanner() {
        actions.assertElementVisible(checkoutElement.fpBannertext);
        actions.clickElement(checkoutElement.closeBtn);
        if(actions.isElementDisplayed(checkoutElement.saveChangesPopUp)){
            actions.clickElement(checkoutElement.saveChangesYesbtn);
        }

    }

    public void verifyPlaceOrderButtonDisabled() {

        actions.assertElementDisabled(checkoutElement.placeOrderBtn);
    }
}
