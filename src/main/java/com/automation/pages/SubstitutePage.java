package com.automation.pages;

import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import com.automation.pageElements.SubstituteElement;
import com.automation.pageElements.CartElements;
import io.appium.java_client.AppiumDriver;

public class SubstitutePage {
    MobileActions actions;

    public SubstitutePage(AppiumDriver driver){

        actions = new MobileActions(driver);
    }

    public void addSubstitution() {
        actions.clickFirstElement(SubstituteElement.editBtn);
        actions.verifyRadioButtonSelected(SubstituteElement.substituteWithBestMatchRBtn);
        actions.clickElement(SubstituteElement.setSubstitutionsForAllLink);
        actions.clickElement(SubstituteElement.saveSubstitutionsBtn);
        actions.waitForElement(CartElements.checkoutBtn);
    }
}
