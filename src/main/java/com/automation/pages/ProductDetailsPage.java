package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import com.automation.pageElements.ProductDetailsElement;
import com.automation.pageElements.HomeElement;
import io.appium.java_client.AppiumDriver;

public class ProductDetailsPage {

    MobileActions actions;
    ProductDetailsElement productDetailsElement;
    HomeElement homeelement;

    public ProductDetailsPage( AppiumDriver driver){

       actions = new MobileActions(driver);
       productDetailsElement = new ProductDetailsElement(driver);
       homeelement = new HomeElement(driver);
    }

    public void verifyProductDetails() {
        actions.assertElementVisible(productDetailsElement.productPrice);
        actions.assertElementVisible(productDetailsElement.productName);

    }

    public void scrollThroughDetails() {
        actions.scrollDownUntillElementVisible(productDetailsElement.productDetails);
    }

    public void addToCart() {
        actions.clickElement(productDetailsElement.addToCartBtn);
        actions.navigateBack();
        actions.navigateBack();
        actions.assertElementVisible(homeelement.bannerSectionAtTop);
    }
}
