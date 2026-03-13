package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import com.automation.pageElements.CheckoutElement;
import io.appium.java_client.AppiumDriver;

public class CheckoutPage {
    MobileActions actions;

    public CheckoutPage(AppiumDriver driver){
        //this.driver = DriverManager.getDriver();
        actions = new MobileActions(driver);
    }

    public void verifyDeliverySlots() {
        actions.assertElementVisible(CheckoutElement.deliverySlotBtn);
        actions.clickElement(CheckoutElement.deliverySlotBtn);

    }

    public void verifyFreshPassBanner() {
        actions.assertElementVisible(CheckoutElement.fpBannertext);
        actions.clickElement(CheckoutElement.closeBtn);
        if(actions.isElementDisplayed(CheckoutElement.saveChangesPopUp)){
            actions.clickElement(CheckoutElement.saveChangesYesbtn);
        }
        if(actions.isElementDisplayed(CheckoutElement.DeliveryTimeIsUnavailable)){
            actions.clickElement(CheckoutElement.DeliveryTimeIsUnavailableOkayBtn);
            actions.clickElement(CheckoutElement.closeBtn);
        }
    }

    public void verifyPlaceOrderButtonDisabled() {
        actions.assertElementDisabled(CheckoutElement.placeOrderBtn);
    }
}
