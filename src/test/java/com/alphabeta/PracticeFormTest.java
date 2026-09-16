package com.alphabeta;

import com.alphabeta.objects.HomeObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class PracticeFormTest {
    static WebDriver driver;

    @BeforeSuite
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setup() {
        driver.get("https://alphabetaops.com/");
    }

    @Test
    public void testPracticeForm() {
        driver.findElement(HomeObjects.NOVICE_LINK).click();
        driver.findElement(HomeObjects.PRACTICE_FORM_LINK).click();
        driver.findElement(HomeObjects.BASIC_FORM_LINK).click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.content-iframe")));

        driver.findElement(HomeObjects.USERNAME_FIELD).sendKeys("Nitin");
        driver.findElement(HomeObjects.PASSWORD_FIELD).sendKeys("Password123");
        driver.findElement(HomeObjects.COMMENTS_FIELD).sendKeys("This is Playwright test");

        driver.findElement(HomeObjects.GENDER_MALE).click();
        driver.findElement(HomeObjects.SKILLS).click();

        new Select(driver.findElement(HomeObjects.EXPERIENCE)).selectByVisibleText("1-2 Years");

        Select tools = new Select(driver.findElement(HomeObjects.AUTOMATION_TOOLS));
        tools.selectByVisibleText("Selenium");
        tools.selectByVisibleText("Playwright");
        tools.selectByVisibleText("Cypress");

        driver.findElement(HomeObjects.CHOOSE_FILE)
                .sendKeys(Paths.get("src/test/resources/resume.pdf").toAbsolutePath().toString());

        driver.findElement(HomeObjects.SUBMIT_BUTTON).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.switchTo().defaultContent();
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}