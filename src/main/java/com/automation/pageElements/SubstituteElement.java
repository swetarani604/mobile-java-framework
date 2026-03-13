package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubstituteElement {
    public SubstituteElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Substitute with best match Edit\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public List<MobileElement> editBtn;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Substitute with best match\")]/..//android.widget.RadioButton")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement substituteWithBestMatchRBtn;

    @AndroidFindBy(accessibility = "Set substitutions for all items, button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement setSubstitutionsForAllLink;

    @AndroidFindBy(accessibility = "Save substitutions, button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public MobileElement saveSubstitutionsBtn;

}