package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import com.automation.pageElements.CartElements;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CartPage {

    MobileActions actions;

    public CartPage(AppiumDriver driver){
        //this.driver = DriverManager.getDriver();
       actions = new MobileActions(driver);
    }
    CartElements cartElements = new CartElements();
    public void openCart() {
        actions.clickElement(CartElements.cartIcon);
        actions.waitForElement(CartElements.checkoutBtn);

    }

    public void verifyProductInCart(String product) {
        actions.verifyMultipleElementsPresent(CartElements.cartProducts);
    }

    public void proceedToCheckout() {
        actions.clickElement(CartElements.checkoutBtn);
        actions.assertElementVisible(CartElements.forgetSomethingTxt);
        actions.clickElement(CartElements.continueToCheckoutBtn);
    }

    public void navigateBackToCart() {
        actions.navigateBack();
        actions.waitForElement(CartElements.checkoutBtn);
    }

    public void removeProductFromCart() {

        actions.clickAllElements(cartElements.removeBtn);
    }

    public void verifyEmptyCartMessage(String emptyCartMessage) {
        actions.assertElementText(CartElements.cartEmptyText,emptyCartMessage);
    }
}
