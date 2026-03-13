package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class HomeElement {

    @AndroidFindBy(id = "com.safeway.client.android.albertsons:id/cl_halo_navigation")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement bannerSectionAtTop;

    @AndroidFindBy(id="com.safeway.client.android.albertsons:id/sv_global")
    @iOSXCUITFindBy(xpath = "")
    public static MobileElement searchBar;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cv_suggestions\")]/android.view.View/android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "")
    public static List<MobileElement> relatedProductList;

}
