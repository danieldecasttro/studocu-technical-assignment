package org.danielCastro;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:reports/test-report.html"}, tags = "@Test", features = {"src/test/java/scenarios"})

public class CucumberRunner {

    public static String setChromeDriverPath() {
        String OS = System.getProperty("os.name").toLowerCase();
        String chromeDriverPath = null;
        if (OS.indexOf("win") >= 0) {
            chromeDriverPath = "src/test/resources/chromedriver_Windows.exe";
        } else if (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") > 0) {
            chromeDriverPath = "src/test/resources/chromedriver_Unix";
        } else {
            System.out.println("Your OS is not supported by the ChromeDrivers available in this project.");
        }
        return chromeDriverPath;
    }

    @BeforeClass
    public static void setup() {
        setChromeDriverPath();
        System.setProperty("webdriver.chrome.driver", setChromeDriverPath());
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {

        if (StepDefinitions.driver != null) {
            StepDefinitions.driver.quit();
        }
    }
}
