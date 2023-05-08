package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {

    @CacheLookup
            @FindBy(id ="user-name")
            WebElement userName;
    @CacheLookup
            @FindBy(id = "password")
            WebElement password;
    @CacheLookup
            @FindBy(id = "login-button")
            WebElement clickOnLogin;
    @CacheLookup
            @FindBy(xpath ="//span[@class = 'title']")
            WebElement productText;

    @CacheLookup
            @FindBy(className= "inventory_item")
            List<WebElement> products6;
    public void sendTextToUserNameField() {
        sendTextToElement(userName, "standard_user");
        CustomListeners.test.log(Status.PASS, "Enter userName field :"+ userName);
        Reporter.log("Enter userName field :"+ userName + userName.toString());
    }
    public void sendTextToPasswordField() {
        sendTextToElement(password, "secret_sauce");
        CustomListeners.test.log(Status.PASS, "Enter userName field :"+ password);
        Reporter.log("Enter userName field :"+ password + password.toString());

    }
    public void clickOnLoginButton() {
        clickOnElement(clickOnLogin);
        CustomListeners.test.log(Status.PASS, "click on Login button");
        Reporter.log("click on Login button" + clickOnLogin.toString());
    }

    public String getProductText(){
        CustomListeners.test.log(Status.PASS, "verify product text");
        Reporter.log("verify product text" + productText.toString());
        return getTextFromElement(productText);
    }

    public void get6Products(){
        List<WebElement> totalProducts = products6;
        System.out.println("Total Numbers of Products" + totalProducts.size());
        CustomListeners.test.log(Status.PASS, "verify 6 products");
        Reporter.log("click on Login button" + products6.toString());
    }
}
