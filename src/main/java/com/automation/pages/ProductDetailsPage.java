package com.automation.pages;

import com.automation.utils.MobileActions;
import com.automation.pageElements.ProductDetailsElement;
import io.appium.java_client.AppiumDriver;

public class ProductDetailsPage {

    MobileActions actions;
    ProductDetailsElement productDetailsElement;

    public ProductDetailsPage( AppiumDriver driver){

       actions = new MobileActions(driver);
       productDetailsElement = new ProductDetailsElement(driver);
    }

    public void verifyProductDetails() {
        actions.waitForElement(productDetailsElement.productPrice);
        actions.assertElementVisible(productDetailsElement.productPrice);
        actions.assertElementVisible(productDetailsElement.productName);

    }

    public void scrollThroughDetails() {
        actions.scrollDownUntilElementVisible(productDetailsElement.productDetails);
    }

    public void addToCart() {
        actions.clickElement(productDetailsElement.addToCartBtn);
        actions.navigateBack();
        actions.navigateBack();
        actions.navigateBack();

    }
}
