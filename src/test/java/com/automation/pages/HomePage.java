package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{
    @FindBy(xpath ="//h1//span[contains(text(),'Automation')]")
    WebElement homePageHeading;

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signUpOrLoginBtn;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignUpTitle;

    @FindBy(name = "name")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@name=\"name\"]/following-sibling::input[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signUpBtn;



    @FindBy(xpath = "//a[text()=' Logged in as ']//b")
    WebElement loggedInfo;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    WebElement deleteAccountBtn;

    @FindBy(xpath = "//h2//b[text()='Account Deleted!']")
    WebElement accountDeletedText;

    public void openWebsite() {
        driver.get(ConfigReader.getConfig("application.url"));
    }

    public boolean isHomePageVisible() {
        return homePageHeading.isDisplayed();
    }



    public boolean isNewUserSignUPVisible() {
        return newUserSignUpTitle.isDisplayed();
    }

    public void clickOnSignUpOrLoginBtn() {
        signUpOrLoginBtn.click();
    }

    public void fillUserNameAndPassword() {
        userNameInput.sendKeys(ConfigReader.getConfig("username"));
        emailInput.sendKeys(ConfigReader.getConfig("email"));
    }

    public void clickOnSignUpBtn() {
        signUpBtn.click();
    }



    public String getLoggedInfo() {
        return loggedInfo.getText();
    }

    public void clickOnDeleteAccount() {
        deleteAccountBtn.click();
    }

    public boolean isAccountDeletedTextVisible() {
        return accountDeletedText.isDisplayed();
    }
}
