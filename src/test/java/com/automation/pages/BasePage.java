package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions actions;
    public BasePage(){
        driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js=(JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
}
