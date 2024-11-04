package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ReviewPage extends BasePage{
      @FindBy(xpath = "//ul[@id=\"address_delivery\"]//li")
      List<WebElement> customerAddress;
      @FindBy(xpath = "//textarea")
      WebElement commentSection;
      @FindBy(xpath = "//a[text()='Place Order']")
      WebElement placeOrder;

    public void verifyAddress() {
        String customerName=customerAddress.get(1).getText().replace("Mr. ","");
        String[] nameparts=customerName.split(" ");
        String firstName=nameparts[0];
        String lastName=nameparts[1];
        Assert.assertEquals(firstName, ConfigReader.getConfig("first.name"));
        Assert.assertEquals(lastName, ConfigReader.getConfig("last.name"));
       String address = customerAddress.get(3).getText().trim();
      // Assert.assertEquals(address,ConfigReader.getConfig("address"));
       String phnNum=customerAddress.get(7).getText();
        Assert.assertEquals(phnNum,ConfigReader.getConfig("mobile.number"));
    }

    public void addComment() {
        commentSection.sendKeys("Deliver with Care");
    }

    public void clickOnPlaceOrder() {
        placeOrder.click();
    }


}
