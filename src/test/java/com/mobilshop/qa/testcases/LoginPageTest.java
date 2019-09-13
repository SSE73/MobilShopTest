package com.mobilshop.qa.testcases;

import com.mobilshop.qa.base.TestBase;
import com.mobilshop.qa.pages.HomePage;
import com.mobilshop.qa.pages.LoginPage;
import com.mobilshop.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    GooglePage googlePage;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitlePageTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"OK.RU");
    }

    @Test(priority = 2)
    public void checkIncorrectLoginTest() {
        loginPage.login("IncorrectLogin", prop.getProperty("password"));
        Assert.assertEquals(loginPage.getErrorLoginText(), "Incorrect username and/or password");
    }

    @Test(priority = 3)
    public void checkIncorrectPasswordTest() {
        loginPage.login(prop.getProperty("username"), "IncorrectPassword");
        Assert.assertEquals(loginPage.getErrorLoginText(), "Incorrect username and/or password");
    }

    @Test(priority = 4)
    public void checkEmptyLoginTest() {
        loginPage.login("",prop.getProperty("password"));
        Assert.assertEquals(loginPage.getErrorLoginText(), "Enter your username");
    }

    @Test(priority = 5)
    public void checkEmptyPasswordTest() {
        loginPage.login(prop.getProperty("username"), "");
        Assert.assertEquals(loginPage.getErrorLoginText(), "Enter password");
    }

    @Test(priority = 6)
    public void checkEmptyLoginAndEmptyPasswordTest() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorLoginText(), "Enter your username");
    }

    @Test(priority = 7)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(homePage.verifyHomePageTitle(), "Одноклассники");
    }

    @Test(priority = 8)
    public void loginGoogleTest() {
        homePage = loginPage.loginGoogle(prop.getProperty("username_google"), prop.getProperty("password_google"));
        boolean flag = homePage.validateLogoImage();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
