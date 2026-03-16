package com.automation.pages;

import com.automation.utils.MobileActions;
import io.appium.java_client.AppiumDriver;
import com.automation.pageElements.ProductResultElements;

public class ProductResultPage {

    MobileActions actions;
    ProductResultElements productResultElement;
    public ProductResultPage(AppiumDriver driver){

        actions = new MobileActions(driver);
        productResultElement = new ProductResultElements(driver);
    }

    public void verifyResultsText(String resultText) {
        actions.waitForElement(productResultElement.resultText);
        actions.assertElementText(productResultElement.resultText, resultText);
    }

    public void verifyProductList() {
        actions.verifyMultipleElementsPresent(productResultElement.productName);
        actions.verifyMultipleElementsPresent(productResultElement.productPrice);

    }

    public void openFirstProduct() {

        actions.clickFirstElement(productResultElement.productName);
    }
}
