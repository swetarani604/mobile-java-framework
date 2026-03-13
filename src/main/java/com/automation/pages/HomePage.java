package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import io.appium.java_client.AppiumDriver;
import com.automation.pageElements.HomeElement;

public class HomePage{
    MobileActions actions;

    public HomePage(AppiumDriver driver){
         //this.driver = DriverManager.getDriver();
        actions = new MobileActions(driver);
    }

    public void verifyHomeScreen() {
        actions.assertElementVisible(HomeElement.bannerSectionAtTop);
    }

    public void searchProduct(String product) {
        actions.clickElement(HomeElement.searchBar);
        actions.enterText(HomeElement.searchBar,product);
        //actions.clickElement(HomeElement.productName);
    }

    public void selectSearchSuggestion(String product) {
        actions.clickElementFromListByText(HomeElement.relatedProductList,product);

    }
}
