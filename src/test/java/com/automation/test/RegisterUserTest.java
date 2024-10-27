package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {
    @Test
    public void registerUserTest(){
        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageVisible());
        homePage.clickOnSignUpOrLoginBtn();
        Assert.assertTrue(homePage.isNewUserSignUPVisible());
        homePage.fillUserNameAndPassword();
        homePage.clickOnSignUpBtn();
        Assert.assertTrue(loginPage.isEnterAccountInformationVisible());
        loginPage.fillDetails();
        loginPage.selectCheckBoxSignUpForNewsLetter();
        loginPage.selectCheckboxRecieveSpecialOffers();
        loginPage.fillAdressInfo();
        Assert.assertTrue(loginPage.isAccountCreatedTextVisible());
        loginPage.clickOnContinueBtn();
        Assert.assertEquals(homePage.getLoggedInfo(), ConfigReader.getConfig("username"));
        homePage.clickOnDeleteAccount();
        Assert.assertTrue(homePage.isAccountDeletedTextVisible());


    }
}
