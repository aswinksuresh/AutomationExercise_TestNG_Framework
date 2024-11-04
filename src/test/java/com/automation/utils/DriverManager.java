package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    static WebDriver driver;
    public static  void createDriver(){
        Map<String, String> capabilities = new HashMap<>();
        capabilities.put("download.default_directory",System.getProperty("user.dir")+ "/src/test/resources/data");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",capabilities);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
