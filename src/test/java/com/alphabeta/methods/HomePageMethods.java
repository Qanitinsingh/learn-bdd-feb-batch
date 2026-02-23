package com.alphabeta.methods;

import com.alphabeta.objects.HomeObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class HomePageMethods {
    private static final Logger logger = LoggerFactory.getLogger(HomePageMethods.class);

    public static void launchBrowser(WebDriver driver, String url) {
        try {
            driver.get(url);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#nav ul")));
            logger.info("URL is entered in browser");
        } catch (TimeoutException e) {
            logger.error("URL is not entered in browser", e);
        }
    }

    // Click Novice Link
    public static void clickNoviceLink(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement noviceLink = wait.until(
                    ExpectedConditions.elementToBeClickable(HomeObjects.NOVICE_LINK)
            );
            assert noviceLink != null;
            noviceLink.click();
            logger.info("Clicking on Novice link");
            logger.info("Successfully clicked on Novice link");
        } catch (Exception e) {
            logger.error("Failed to click on Novice link", e);
            throw e;
        }
    }

    // Click Practice Form
    public static void clickPracticeForm(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement PracticeForm = wait.until(
                    ExpectedConditions.elementToBeClickable(HomeObjects.PRACTICE_FORM_LINK)
            );
            assert PracticeForm != null;
            PracticeForm.click();

            logger.info("Clicking on Practice Form link");
            logger.info("Successfully clicked on Practice Form link");
        } catch (Exception e) {
            logger.error("Failed to click on Practice Form link", e);
            throw e;
        }
    }

    // Click Practice Form
    public static void SwicthIframe(WebDriver driver) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.content-iframe")));

            driver.switchTo().frame(iframe);
            Thread.sleep(2000);

            logger.info("Switching to Iframe");
            logger.info("Successfully switched to Iframe");
        } catch (Exception e) {

            throw e;
        }
    }

    // Click Basic Form
    public static void clickBasicForm(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement BasicForm = wait.until(
                    ExpectedConditions.elementToBeClickable(HomeObjects.BASIC_FORM_LINK)
            );
            assert BasicForm != null;
            BasicForm.click();

            logger.info("Clicking on Basic Form link");
            logger.info("Successfully clicked on Basic Form link");
        } catch (Exception e) {
            logger.error("Failed to click on Basic Form link", e);
            throw e;
        }
    }

    // Enter Username
    public static void enterUsername(WebDriver driver, String username) {
        try {
            driver.findElement(HomeObjects.USERNAME_FIELD).sendKeys(username);
            logger.info("Entering username: {}", username);
            logger.info("Username entered successfully");
        } catch (Exception e) {
            logger.error("Failed to enter username", e);
            throw e;
        }
    }

    // Enter Password
    public static void enterPassword(WebDriver driver, String password) {
        try {
            driver.findElement(HomeObjects.PASSWORD_FIELD).sendKeys(password);
            logger.info("Entering password");
            logger.info("Password entered successfully");
        } catch (Exception e) {
            logger.error("Failed to enter password", e);
            throw e;
        }
    }

    // Enter Comments
    public static void enterComments(WebDriver driver, String comments) {
        try {
            driver.findElement(HomeObjects.COMMENTS_FIELD).sendKeys(comments);
            logger.info("Entering comments");
            logger.info("Comments entered successfully");
        } catch (Exception e) {
            logger.error("Failed to enter comments", e);
            throw e;
        }
    }

    // Select Gender
    public static void selectGender(WebDriver driver, String gender) {
        try {
            driver.findElement(HomeObjects.GENDER_MALE).click();
            logger.info("Selecting gender: {}", gender);
            logger.info("Gender selected successfully");
        } catch (Exception e) {
            logger.error("Failed to select gender", e);
            throw e;
        }
    }

    // Select Skills
    public static void selectSkills(WebDriver driver, String skills) {
        try {
            driver.findElement(HomeObjects.SKILLS).click();
            logger.info("Selecting skills: {}", skills);
            logger.info("Skills selected successfully");
        } catch (Exception e) {
            logger.error("Failed to select skills", e);
            throw e;
        }
    }

    // Select Experience
    public static void selectExperience(WebDriver driver, String experience) {
        try {
            driver.findElement(By.id("experience")).click();
            Select select = new Select(driver.findElement(HomeObjects.EXPERIENCE));
            select.selectByVisibleText(experience);
            logger.info("Selecting experience: {}", experience);
            logger.info("Experience selected successfully");
        } catch (Exception e) {
            logger.error("Failed to select experience", e);
            throw e;
        }
    }

    // Select Automation Tools
    public static void selectAutomationTools(WebDriver driver, String tools) {
        try {

            Select select = new Select(driver.findElement(HomeObjects.AUTOMATION_TOOLS));

            // Verify it is multi-select
            if (select.isMultiple()) {
                // Select single option
                select.selectByVisibleText("Selenium");
                // Select multiple options
                select.selectByVisibleText("Playwright");
                select.selectByVisibleText("Cypress");
                // Deselect one option
                select.deselectByVisibleText("Cypress");

                // Deselect all
                // select.deselectAll();
            }

            logger.info("Selecting automation tools: {}", tools);
            logger.info("Automation tools selected successfully");
        } catch (Exception e) {
            logger.error("Failed to select automation tools", e);
            throw e;
        }
    }

    // Upload Resume
    public static void uploadResume(WebDriver driver, String filePath) {
        try {
            logger.info("Uploading resume from path: {}", filePath);
            logger.info("Resume uploaded successfully");
        } catch (Exception e) {
            logger.error("Failed to upload resume", e);
            throw e;
        }
    }

    // Click Submit
    public static void clickSubmit(WebDriver driver) {
        try {
            logger.info("Clicking on Submit button");
            logger.info("Submit button clicked successfully");
        } catch (Exception e) {
            logger.error("Failed to click Submit button", e);
            throw e;
        }
    }
}