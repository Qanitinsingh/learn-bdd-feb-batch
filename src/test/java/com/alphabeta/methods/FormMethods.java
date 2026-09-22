package com.alphabeta.methods;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class FormMethods {

    private static final Logger logger = LoggerFactory.getLogger(FormMethods.class);
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);


    public static void verifyFormPAge(WebDriver driver, String formPageUrl) {

        try {
            logger.info("[{}] Navigating to URL: {}",  formPageUrl);
            driver.navigate().to(formPageUrl);
            logger.info("[{}] Navigation successful", formPageUrl);
        } catch (Exception e) {
            logger.error("[{}] Error navigating to page: {}",  e.getMessage(), e);
            throw e;
        }
    }

    public static void fillform(WebDriver driver, Map<String,String> data) {
        try {
            logger.info("Filling form with data: {}", data);
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-firstname']")))
                    .sendKeys(data.get("FirstName"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-middlename']")))
                    .sendKeys(data.get("MiddleName"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-lastname']")))
                    .sendKeys(data.get("LastName"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-email']")))
                    .sendKeys(data.get("Email"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-password']")))
                    .sendKeys(data.get("Password"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-address']")))
                    .sendKeys(data.get("Address"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-city']")))
                    .sendKeys(data.get("City"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-states']")))
                    .sendKeys(data.get("State"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='form-pincode']")))
                    .sendKeys(data.get("Pin"));
        }
        catch (Exception e)
        {
            logger.error("Error filling form: {}", e.getMessage(), e);
            throw e;     }
    }

    public static void submitForm(WebDriver driver) {

        try {
            logger.info("[{}] Submitting form");
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("[data-testid='form-submit-btn']"))).click();
        } catch (Exception e) {
            logger.error("[{}] Error submitting form: {}", e.getMessage(), e);
            throw e;
        }
    }

    public static void verifySuccessFormSubmit(WebDriver driver) {

        try {
            logger.info("[{}] Verifying successful form submission");
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.cssSelector("[data-testid='form-message']"),
                    "Form submitted successfully"));
        } catch (Exception e) {
            logger.error("[{}] Error verifying form submission: {}",  e.getMessage(), e);
            throw e;
        }
    }

}
