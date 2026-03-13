package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.pageElements.SubstituteElement;
import com.automation.utils.MobileActions;
import com.automation.pageElements.CartElements;
import io.appium.java_client.AppiumDriver;

public class SubstitutePage {
    MobileActions actions;
    SubstituteElement substituteElement;
    CartElements cartElements;
    public SubstitutePage(AppiumDriver driver){

        actions = new MobileActions(driver);
        substituteElement = new SubstituteElement(driver);
        cartElements = new CartElements(driver);
    }

    public void addSubstitution() {
        actions.clickFirstElement(substituteElement.editBtn);
        actions.verifyRadioButtonSelected(substituteElement.substituteWithBestMatchRBtn);
        actions.clickElement(substituteElement.setSubstitutionsForAllLink);
        actions.clickElement(substituteElement.saveSubstitutionsBtn);
        actions.waitForElement(cartElements.checkoutBtn);
    }
}
