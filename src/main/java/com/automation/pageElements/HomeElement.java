package com.automation.pageElements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
    @iOSXCUITFindBy(xpath = "")
    public MobileElement bannerSectionAtTop;

    @AndroidFindBy(id="com.safeway.client.android.albertsons:id/sv_global")
    @iOSXCUITFindBy(xpath = "")
    public MobileElement searchBar;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cv_suggestions\")]/android.view.View/android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "")
    public List<MobileElement> relatedProductList;


}
