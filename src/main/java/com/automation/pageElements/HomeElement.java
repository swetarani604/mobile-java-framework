package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeElement {
    public HomeElement(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/clHeroCanvasBanner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name CONTAINS 'banner'`]")
    public WebElement bannerSectionAtTop;

    @AndroidFindBy(id="com.safeway.client.android.albertsons:id/sv_global")
    @iOSXCUITFindBy(accessibility = "searchBar")
    public WebElement searchBar;

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.EditText\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSearchField'")
    public WebElement searchEntertxt;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cv_suggestions\")]/android.view.View/android.view.View/android.view.View")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView/**/XCUIElementTypeCell")
    public List<WebElement> relatedProductList;

}
