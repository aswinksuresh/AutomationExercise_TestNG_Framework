package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//h2[text()='recommended items']")
    WebElement recommendedItemsTitle;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@class='btn btn-default add-to-cart']")
    List<WebElement> addToCartBtnRecommendedITems;

    @FindBy(xpath = "//a[@class='right recommended-item-control']//i[@class='fa fa-angle-right']")
    WebElement rightNavigationBtnRecommendedItems;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingPopUpBtn;

    @FindBy(xpath = "//div[@class='recommended_items']//p")
    List<WebElement> recommendedProducts;

    @FindBy(xpath = "//a[text()=' Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[text()='Add to cart']")
    List<WebElement> allAddTOCartBtns;

    int cnt =0;
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

    public void scrollToBottomOfPage() {
        js.executeScript("window.scrollTo(2, document.body.scrollHeight);");
    }



    public boolean isRecommendedItemstitleVisible() {

        return recommendedItemsTitle.isDisplayed();
    }

    public void clickOnAddToCartBtnOnRecommendedItems() {

        for (int i=0;i<recommendedProducts.size();i++){
            wait.until(ExpectedConditions.visibilityOf(recommendedProducts.get(i)));
            ConfigReader.setProperty("product"+i,recommendedProducts.get(i).getText());
        }
        for (WebElement btn : addToCartBtnRecommendedITems){
            js.executeScript("arguments[0].click();", btn);
            cnt ++;
            continueShoppingPopUpBtn.click();
            if(cnt ==2){
                rightNavigationBtnRecommendedItems.click();
                wait.until(ExpectedConditions.visibilityOf(recommendedProducts.get(0)));
            }

        }
    }

    public void goToCartPage() {
        cartLink.click();
    }

    public void addAllItemsToCart() {
        for (WebElement btn:allAddTOCartBtns){
          js.executeScript("arguments[0].click();", btn);
          continueShoppingPopUpBtn.click();
        }
    }
}
