package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import com.automation.pageElements.ProductDetailsElement;
import com.automation.pageElements.HomeElement;
import io.appium.java_client.AppiumDriver;

public class ProductDetailsPage {

    MobileActions actions;

    public ProductDetailsPage( AppiumDriver driver){
       // this.driver = DriverManager.getDriver();
       actions = new MobileActions(driver);
    }

    public void verifyProductDetails() {
        actions.assertElementVisible(ProductDetailsElement.productPrice);
        actions.assertElementVisible(ProductDetailsElement.productName);

    }

    public void scrollThroughDetails() {
        actions.scrollDownUntillElementVisible(ProductDetailsElement.productDetails);
    }

    public void addToCart() {
        actions.clickElement(ProductDetailsElement.addToCartBtn);
        actions.navigateBack();
        actions.navigateBack();
        actions.assertElementVisible(HomeElement.bannerSectionAtTop);
    }
}
