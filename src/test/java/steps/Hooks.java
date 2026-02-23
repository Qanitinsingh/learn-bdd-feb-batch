package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                // Clean scenario name (remove special characters)
                String screenshotName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9]", "_");

                System.out.println("Failed Scenario: " + screenshotName);

                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                // Attach with proper name
                scenario.attach(screenshot, "image/png", screenshotName);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}