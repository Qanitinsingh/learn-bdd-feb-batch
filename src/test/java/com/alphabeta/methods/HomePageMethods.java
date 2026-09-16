package com.alphabeta.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HomePageMethods {
    private static final Logger logger = LoggerFactory.getLogger(HomePageMethods.class);
    private static final By LEFT_SIDEBAR_MENU_ITEMS = By.cssSelector("div.mb-2 ul li.list-group-item");

    public static void launchBrowserAndNavigateToHomePage(WebDriver driver, String url) {
        try {
            driver.get(url);
            logger.info("Launching browser and navigating to home page... {}", url);
        } catch (Exception e) {
            logger.error("Error launching browser and navigating to home page: {}", e.getMessage(), e);
            throw e;
        }
    }

    public static void verifyLeftSidebarMenuItemsOneByOne(WebDriver driver) {
        try {
            logger.info("Verifying left sidebar menu items one by one...");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> menuItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(LEFT_SIDEBAR_MENU_ITEMS));

            int count = menuItems.size();
            logger.info("Total left sidebar menu items found: {}", count);

            for (int i = 0; i < count; i++) {
                WebElement menuItem = menuItems.get(i);
                String menuName = menuItem.getText().trim();

                logger.info("Clicking menu item {}: {}", i + 1, menuName);
                wait.until(ExpectedConditions.elementToBeClickable(menuItem)).click();
                logger.info("Successfully clicked menu item: {}", menuName);
            }

        } catch (Exception e) {
            logger.error("Error verifying left sidebar menu items one by one: {}", e.getMessage(), e);
            throw e;
        }
    }

    public static void closeBrowser(WebDriver driver) {
        try {
            if (driver != null) {
                driver.quit();
            }
            logger.info("Closing browser...");
        } catch (Exception e) {
            logger.error("Error closing browser: {}", e.getMessage(), e);
            throw e;
        }
    }
}