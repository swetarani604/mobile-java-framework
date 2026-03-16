package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubstituteElement {
    public SubstituteElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Substitute with best match Edit\")]/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Edit'")
    public List<WebElement> editBtn;

    @AndroidFindAll({
            @AndroidBy(xpath = "//*[contains(@text,\"Substitute with best match\")]/..//android.widget.RadioButton"),
            @AndroidBy(accessibility = "selected, Substitute with best match")
    })
    @iOSXCUITFindBy(accessibility = "substituteBestMatch")
    public WebElement  substituteWithBestMatchRBtn;

    @AndroidFindBy(accessibility = "Set substitutions for all items, button")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Substitutions'")
    public WebElement  setSubstitutionsForAllLink;

    @AndroidFindBy(accessibility = "Save substitutions, button")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label CONTAINS 'Save'`]")
    public WebElement  saveSubstitutionsBtn;

}