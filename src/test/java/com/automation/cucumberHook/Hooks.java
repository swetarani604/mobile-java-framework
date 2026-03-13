package com.automation.cucumberHook;

import com.automation.driver.DriverFactory;
import com.automation.driver.DriverManager;
import com.automation.utils.MobileActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterSuite;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
        @Before
        public void setUp () {

        // Read platform from cmd or default to android
        String platform = System.getProperty("platform");

        if (platform == null || platform.isEmpty()) {
            platform = "android";
        }

        // Initialize driver for the given platform
        DriverFactory.initializeDriver(platform);
    }

    @After
    public void afterScenario(Scenario scenario) {

        try {

            if (scenario.isFailed()) {

                String screenshotPath = MobileActions.captureScreenshot(scenario.getName());

                byte[] fileContent = Files.readAllBytes(Paths.get(screenshotPath));

                scenario.attach(fileContent, "image/png", "Failure Screenshot");

            }

        } catch (Exception e) {

            scenario.log("Screenshot capture failed: " + e.getMessage());

        }
    }

    @AfterSuite
    public void tearDown () {

        // Quit driver after scenario
        DriverManager.quitDriver();
    }
}
