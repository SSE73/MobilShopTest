package com.mobilshop.qa.testcases;

import com.mobilshop.qa.base.TestBase;
import com.mobilshop.qa.pages.*;
import com.mobilshop.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        Assert.assertEquals(homePage.verifyHomePageTitle(), "Одноклассники");
    }

    @Test(priority = 2)
    public void logoImageTest() {
        boolean flag = homePage.validateLogoImage();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
