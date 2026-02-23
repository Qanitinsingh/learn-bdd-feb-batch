package com.alphabeta;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class PracticeFormTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;
    @BeforeSuite
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
    }
    @BeforeMethod
    public void setup() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://alphabetaops.com/");
    }

    @Test
    public void testPracticeForm() {

        // Click Novice
        page.locator("div.mb-2:first-child").click();

        // Click Practice Form
        page.locator("div.mb-2:first-child ul li.list-group-item:last-child").click();
        page.locator("div.mb-2:first-child ul li.list-group-item:last-child a").click();
        // Switch to iframe (Correct way in Playwright)
        FrameLocator frame = page.frameLocator("iframe.content-iframe");

        // Fill Form
        frame.locator("#username").fill("Nitin");
        frame.locator("#password").fill("Password123");
        frame.locator("#comments").fill("This is Playwright test");

        // Select Gender
        frame.locator("//input[@value='male']").check();

        // Select Skills
        frame.locator("//input[@value='java']").check();

        // Select Experience dropdown
        frame.locator("#experience")
                .selectOption(new SelectOption().setLabel("1-2 Years"));

        // Multi Select Automation Tools
        frame.locator("#tools")
                .selectOption(new String[]{"Selenium", "Playwright", "Cypress"});

        // Upload Resume
        frame.locator("#resume")
                .setInputFiles(Paths.get("src/test/resources/resume.pdf"));

        // Click Submit
        frame.locator("//button[@type='submit']").click();
    }

    @AfterMethod
    public void tearDown() {
        context.close();
    }

    @AfterSuite
    public void closeBrowser() {
        browser.close();
        playwright.close();
    }
}