package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class SubstituteElement {

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Substitute with best match Edit\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static List<MobileElement> editBtn;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Substitute with best match\")]/..//android.widget.RadioButton")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement substituteWithBestMatchRBtn;

    @AndroidFindBy(accessibility = "Set substitutions for all items, button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement setSubstitutionsForAllLink;

    @AndroidFindBy(accessibility = "Save substitutions, button")
    @iOSXCUITFindBy(iOSClassChain = "")
    public static MobileElement saveSubstitutionsBtn;

}