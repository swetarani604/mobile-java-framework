package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import io.appium.java_client.AppiumDriver;
import com.automation.pageElements.HomeElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

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
        actions.enterText(homeelement.searchBar,product);

    }

    public void selectSearchSuggestion(String product) {
        actions.clickElementFromListByText(homeelement.relatedProductList,product);

    }
}
