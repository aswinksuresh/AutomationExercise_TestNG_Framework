package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginOrSignUPPage extends BasePage{

    @FindBy(xpath = "//h2/b[text()='Enter Account Information']")
    WebElement enterAccountInfoTitle;

    @FindBy(id="id_gender1")
    WebElement maleRadioBtn;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id="days")
    WebElement daySelector;

    @FindBy(id="months")
    WebElement monthSelector;

    @FindBy(id="years")
    WebElement yearSelector;

    @FindBy(id="newsletter")
    WebElement newsLetterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOfferCheckBox;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastname;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "country")
    WebElement countrySelect;

    @FindBy(id = "state")
    WebElement stateInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "zipcode")
    WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    WebElement mobileNumInput;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccountBtn;

    @FindBy(xpath="//h2//b[text()='Account Created!']")
    WebElement accntCreatedTxt;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;

    public boolean isEnterAccountInformationVisible() {
        return enterAccountInfoTitle.isDisplayed();
    }

    public void fillDetails() {
        maleRadioBtn.click();
        passwordInput.sendKeys(ConfigReader.getConfig("password"));
        Select daySelect = new Select(daySelector);
        daySelect.selectByVisibleText(ConfigReader.getConfig("date.of.birth"));

        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByVisibleText(ConfigReader.getConfig("month.of.birth"));

        Select yearselect= new Select(yearSelector);
        yearselect.selectByVisibleText(ConfigReader.getConfig("year.of.birth"));

    }

    public void selectCheckBoxSignUpForNewsLetter() {
        newsLetterCheckbox.click();
    }

    public void selectCheckboxRecieveSpecialOffers() {
        specialOfferCheckBox.click();
    }

    public void fillAdressInfo() {
        firstName.sendKeys(ConfigReader.getConfig("first.name"));
        lastname.sendKeys(ConfigReader.getConfig("last.name"));
        address.sendKeys(ConfigReader.getConfig("address"));

        Select countrySelector = new Select(countrySelect);
        countrySelector.selectByVisibleText("India");

        stateInput.sendKeys(ConfigReader.getConfig("state"));
        cityInput.sendKeys(ConfigReader.getConfig("city"));
        zipcodeInput.sendKeys(ConfigReader.getConfig("zipcode"));
        mobileNumInput.sendKeys(ConfigReader.getConfig("mobile.number"));
        createAccountBtn.click();
    }

    public boolean isAccountCreatedTextVisible() {
        return accntCreatedTxt.isDisplayed();
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }


}
