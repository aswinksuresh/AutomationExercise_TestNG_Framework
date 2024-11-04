package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItems extends BaseTest{
    @Test
    public void addToCartRecommendedItems(){
        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.scrollToBottomOfPage();
        Assert.assertTrue(homePage.isRecommendedItemstitleVisible());
        homePage.clickOnAddToCartBtnOnRecommendedItems();
        homePage.goToCartPage();
        Assert.assertTrue(cartPage.verifyCart());
    }
}
