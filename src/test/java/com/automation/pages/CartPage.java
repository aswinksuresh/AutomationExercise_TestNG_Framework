package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(xpath = "//li[text()='Shopping Cart']")
    WebElement shoppingCartTitle;
    @FindBy(xpath = "//td[@class='cart_description']//h4")
    List<WebElement> cartProductsNAme;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement proceedTOCheckOutBtn;
    @FindBy(xpath = "//a//u[text()='Register / Login']")
    WebElement signUpOrLoginLinkOnCart;

    public boolean verifyCart() {
        for (int i=0;i<cartProductsNAme.size();i++){
            if(cartProductsNAme.get(i).getText().equals(ConfigReader.getConfig("product"+i))){
                System.out.println("match");
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean isCartPageDisplayed() {
        return shoppingCartTitle.isDisplayed();
    }

    public void clickOnProceedTOCheckout() {
        proceedTOCheckOutBtn.click();
    }

    public void clickOnSignUpOrLogin() {
        signUpOrLoginLinkOnCart.click();
    }
}
