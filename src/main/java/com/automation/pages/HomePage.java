package com.automation.pages;

import com.automation.utils.MobileActions;
import io.appium.java_client.AppiumDriver;
import com.automation.pageElements.HomeElement;
import org.openqa.selenium.By;

public class HomePage{
    MobileActions actions;
    HomeElement homeelement;

    public HomePage(AppiumDriver driver){

        actions = new MobileActions(driver);
        homeelement = new HomeElement(driver);
    }

    public void verifyHomeScreen() {
        actions.assertElementVisible(homeelement.bannerSectionAtTop);
    }

    public void searchProduct(String product) {
        actions.clickElement(homeelement.searchBar);
        actions.enterText(homeelement.searchEntertxt,product);

    }

    public void selectSearchSuggestion(String product) {
        By productLocator = homeelement.getProductLocator(product);
        actions.clickDynamicElement(productLocator);
    }
}
