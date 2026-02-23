package com.alphabeta.objects;

import org.openqa.selenium.By;

public class HomeObjects {

    // Left menu items
        public static final By NOVICE_LINK = By.cssSelector("div.mb-2:first-child");
    public static final By PRACTICE_FORM_LINK = By.cssSelector("div.mb-2:first-child ul li.list-group-item:last-child");
    public static final By BASIC_FORM_LINK = By.cssSelector("div.mb-2:first-child ul li.list-group-item:last-child a");

    // Form elements
    public static final By USERNAME_FIELD = By.id("username");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By COMMENTS_FIELD = By.id("comments");
    public static final By GENDER_MALE = By.xpath("//input[@value='male']");
    public static final By SKILLS = By.xpath("//input[@value='java']");
    public static final By EXPERIENCE = By.xpath("//select[@id='experience']");
    public static final By AUTOMATION_TOOLS = By.id("tools");
    public static final By CHOOSE_FILE = By.xpath("//input[@id='resume']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
}