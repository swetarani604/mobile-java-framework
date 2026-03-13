package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import io.appium.java_client.AppiumDriver;
import com.automation.pageElements.ProductResultElements;

public class ProductResultPage {

    MobileActions actions;

    public ProductResultPage(AppiumDriver driver){
       // this.driver = DriverManager.getDriver();
        actions = new MobileActions(driver);
    }
    public void verifyResultsText(String resultText) {
        actions.waitForElement(ProductResultElements.resultText);
        actions.assertElementText(ProductResultElements.resultText, resultText);
    }

    public void verifyProductList() {
        actions.verifyMultipleElementsPresent(ProductResultElements.productName);
        actions.verifyMultipleElementsPresent(ProductResultElements.productPrice);

    }

    public void openFirstProduct() {
        actions.clickFirstElement(ProductResultElements.productName);
    }
}
