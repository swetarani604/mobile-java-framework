package com.automation.pages;

import com.automation.utils.MobileActions;
import com.automation.pageElements.CartElements;
import io.appium.java_client.AppiumDriver;

import java.util.List;

public class CartPage {

    MobileActions actions;
    CartElements cartElements;
    public CartPage(AppiumDriver driver){

       actions = new MobileActions(driver);
       cartElements = new CartElements(driver);
    }

    public void openCart() {
        actions.clickElement(cartElements.cartIcon);
        actions.waitForElement(cartElements.checkoutBtn);

    }

    public void verifyProductInCart() {
        actions.verifyMultipleElementsPresent(cartElements.cartProducts);
    }

    public void proceedToCheckout() {
        actions.clickElement(cartElements.checkoutBtn);
        actions.assertElementVisible(cartElements.forgetSomethingTxt);
        actions.clickElement(cartElements.continueToCheckoutBtn);
    }

    public void navigateBackToCart() {
        actions.navigateBack();
        actions.waitForElement(cartElements.checkoutBtn);
    }

    public void removeProductFromCart() {

        actions.clickAllElements(cartElements.removeBtn());
    }

    public void verifyEmptyCartMessage(String emptyCartMessage) {
        actions.assertElementText(cartElements.cartEmptyText,emptyCartMessage);
    }
}
