package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage;
    LoginOrSignUPPage loginPage;
    CartPage cartPage;
    ReviewPage reviewPage;
    PaymentPage paymentPage;
    OrderConfirmationPage orderConfirmationPage;
    @BeforeMethod
    public void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        homePage = new HomePage();
        loginPage = new LoginOrSignUPPage();
        cartPage=new CartPage();
        reviewPage = new ReviewPage();
        paymentPage=new PaymentPage();
        orderConfirmationPage=new OrderConfirmationPage();
    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
