package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadInvoice extends BaseTest{
    @Test
    public void verifyInvoiceDownload(){
        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.addAllItemsToCart();
        homePage.goToCartPage();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnProceedTOCheckout();
        cartPage.clickOnSignUpOrLogin();
        Assert.assertTrue(homePage.isNewUserSignUPVisible());
        loginPage.doLogin();
        Assert.assertEquals(homePage.getLoggedInfo(), ConfigReader.getConfig("username"));
        homePage.goToCartPage();
        cartPage.clickOnProceedTOCheckout();
        reviewPage.verifyAddress();
        reviewPage.addComment();
        reviewPage.clickOnPlaceOrder();
        paymentPage.fillPaymentdetailsAndPlaceOrder();
        Assert.assertTrue(orderConfirmationPage.verifySucccessMsg());
        orderConfirmationPage.downloadInvoice();
        orderConfirmationPage.clickOnContinue();
        homePage.clickOnDeleteAccount();
        Assert.assertTrue(homePage.isAccountDeletedTextVisible());

    }
}
