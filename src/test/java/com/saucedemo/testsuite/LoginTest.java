package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage =new LoginPage();
    }
    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValid(){
        //Enter “standard_user” username
        loginPage.sendTextToUserNameField();

        //Enter “secret_sauce” password
        loginPage.sendTextToPasswordField();

        //click on login button
        loginPage.clickOnLoginButton();

        //verify the text products
        Assert.assertEquals(loginPage.getProductText(),"Products");


    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //enter username
        loginPage.sendTextToUserNameField();

        // enter password
        loginPage.sendTextToPasswordField();

        // click on login button
        loginPage.clickOnLoginButton();

        // verify the 6 products
        loginPage.get6Products();
    }
}


