package com.automation.utils;

import com.automation.driver.DriverManager;
import io.appium.java_client.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MobileActions {
    AppiumDriver driver;
    WebDriverWait wait;

    public MobileActions(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
    }

    private final int WAIT_FOR_ELEMENT_TIMEOUT = 15;

    public void scrollDownUntilElementVisible(WebElement element) {

        int maxScroll = 5;   // prevents infinite scrolling
        int count = 0;

        while (!isElementDisplayed(element) && count < maxScroll) {

            Dimension size = driver.manage().window().getSize();

            int startX = size.getWidth() / 2;
            int startY = (int) (size.getHeight() * 0.8);
            int endY = (int) (size.getHeight() * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), startX, startY));

            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                    PointerInput.Origin.viewport(), startX, endY));

            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));

            count++;
        }

        Assert.assertTrue(isElementDisplayed(element),
                "Element not found after scrolling");
    }

    public void swipeLeft() {

        Dimension size = driver.manage().window().getSize();

        int startX = (int) (size.getWidth() * 0.8);
        int endX = (int) (size.getWidth() * 0.2);
        int y = size.getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                y));

        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                endX,
                y));

        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    public WebElement waitForElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void clickElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        int retry = 0;

        while (retry < 3) {
            try {

                WebElement ele = wait.until(
                        ExpectedConditions.elementToBeClickable(element)
                );
                ele.click();
                return;

            } catch (StaleElementReferenceException e) {
                retry++;
            }
        }

        throw new RuntimeException("Unable to click element after retries");
    }

    public void enterText(WebElement element, String text) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        int retry = 0;

        while (retry < 3) {
            try {
                WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));

                ele.clear();
                ele.sendKeys(text);
                return;

            } catch (StaleElementReferenceException e) {
                retry++;
            }
        }

        throw new RuntimeException("Unable to enter text after retries");
    }

    public String getText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
        int retry = 0;

        while (retry < 3) {
            try {

                WebElement ele = (WebElement) wait.until(
                        ExpectedConditions.visibilityOf(element)
                );

                return ele.getText();

            } catch (StaleElementReferenceException e) {
                retry++;
            }
        }

        throw new RuntimeException("Unable to get text after retries");
    }

    public void assertElementVisible(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));

            if (element.isDisplayed()) {
                Assert.assertTrue(true);
            }

        } catch (Exception e) {
            Assert.fail(element + " is not visible");
        }
    }

    public void assertElementText(WebElement element, String expectedText) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));

            String actualText = element.getText();

            if (actualText == null || actualText.isEmpty()) {
                actualText = element.getAttribute("label");   // iOS fallback
            }

            Assert.assertTrue(actualText.trim().contains(expectedText.trim()),
                    actualText.trim() + " is displaying instead of expected");

        } catch (Exception e) {
            Assert.fail("Unable to validate text for " + element);
        }
    }

    public void assertElementDisabled(WebElement element) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(element));

            boolean status = element.isEnabled();

            if (!status) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(element + " is enabled but expected disabled");
            }

        } catch (Exception e) {
            Assert.fail("Unable to verify disabled state for " + element);
        }
    }

    // Clicks on the element from a list if its text matches the expected value
    public void clickElementFromListByText(List<WebElement> elements, String expectedName) {
    boolean found = false;

    for (WebElement element : elements) {
        try {
            // Wait until element is visible
            wait.until(ExpectedConditions.visibilityOf(element));

            String text = element.getText();
            if (text == null || text.isEmpty()) {
                text = element.getAttribute("label"); // iOS purpose
            }

            if (text.trim().equalsIgnoreCase(expectedName.trim())) {
                element.click();
                found = true;
                Assert.assertTrue(true,expectedName.trim()+"is clicked");
                break;
            }

        } catch (StaleElementReferenceException e) {

        } catch (Exception e) {

        }
    }

}
    public void clickAllElements(List<WebElement> list) {
        while (true) {
            if (list.size() == 0) {
                break;
            }
            list.get(0).click();
        }
    }

    public void verifyMultipleElementsPresent(List<WebElement> elements) {
        Assert.assertTrue(elements.size() > 0, "Expected multiple elements but none found");
    }

    public void clickFirstElement(List<WebElement> elements) {
        Assert.assertTrue(elements.size() > 0, "No elements found to click");
        elements.get(0).click();
    }


    public void navigateBack() {

        String platform = driver.getCapabilities()
                    .getCapability("platformName")
                    .toString()
                    .toLowerCase();

        if(platform.contains("android")) {

                // code for Android back navigation
                driver.navigate().back();

        } else if(platform.contains("ios")) {

            try {
                    // iOS - Clicking on top Back button
                    By backBtn = MobileBy.AccessibilityId("Back");
                    driver.findElement(backBtn).click();
            } catch (Exception e) {
                    Assert.fail("Unable to find back button");
                }
        }
    }

    public void selectRadioButtonSelected(WebElement ele) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));

        wait.until(ExpectedConditions.visibilityOf(ele));

        Assert.assertTrue(ele.isDisplayed(), "Radio button is not visible on the screen");

        ele.click();

        Assert.assertTrue(ele.isEnabled(), "Radio button is not selected");
    }

    public boolean isElementDisplayed(WebElement ele) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_FOR_ELEMENT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(ele));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public static String captureScreenshot(String name) {

        try {

            AppiumDriver driver = DriverManager.getDriver();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "target/screenshots/" + name + "_" + System.currentTimeMillis() + ".png";

            FileUtils.copyFile(src, new File(path));

            return path;

        } catch (Exception e) {
            return null;
        }
    }

}
