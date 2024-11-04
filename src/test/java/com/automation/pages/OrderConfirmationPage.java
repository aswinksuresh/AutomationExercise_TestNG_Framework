package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class OrderConfirmationPage extends BasePage{
    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    WebElement orderSuccessMsg;
    @FindBy(xpath = "//a[text()='Download Invoice']")
    WebElement downloadInvoiceBtn;
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;
    public boolean verifySucccessMsg() {
        return orderSuccessMsg.isDisplayed();
    }

    public void downloadInvoice() {

        downloadInvoiceBtn.click();
    }

    public void clickOnContinue() {
        continueBtn.click();
    }

}
