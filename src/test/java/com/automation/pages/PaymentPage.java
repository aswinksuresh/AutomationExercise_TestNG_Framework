package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    @FindBy(name = "name_on_card")
    WebElement nameOnCardInput;
    @FindBy(name="card_number")
    WebElement cardNumInput;
    @FindBy(name = "cvc")
    WebElement cvcInput;
    @FindBy(name = "expiry_month")
    WebElement expiryMnth;
    @FindBy(name = "expiry_year")
    WebElement expiryYr;
    @FindBy(id="submit")
    WebElement placeOrderBtn;


    public void fillPaymentdetailsAndPlaceOrder() {
        nameOnCardInput.sendKeys(ConfigReader.getConfig("username"));
        cardNumInput.sendKeys(ConfigReader.getConfig("card.number"));
        cvcInput.sendKeys(ConfigReader.getConfig("cvc"));
        expiryMnth.sendKeys(ConfigReader.getConfig("expiry.month"));
        expiryYr.sendKeys(ConfigReader.getConfig("expiry.year"));
        placeOrderBtn.click();

    }
}
