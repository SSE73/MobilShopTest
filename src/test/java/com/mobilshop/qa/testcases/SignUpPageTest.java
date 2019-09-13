package com.mobilshop.qa.testcases;

import com.mobilshop.qa.base.TestBase;
import com.mobilshop.qa.models.Gender;
import com.mobilshop.qa.pages.AnonymRegistrationProfilePage;
import com.mobilshop.qa.pages.LoginPage;
import com.mobilshop.qa.pages.SignUpPage;
import com.mobilshop.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SignUpPageTest extends TestBase {

    LoginPage loginPage;
    TestUtil testUtil;
    SignUpPage signUpPage;
    AnonymRegistrationProfilePage anonymRegistrationProfilePage;

    public SignUpPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        anonymRegistrationProfilePage = new AnonymRegistrationProfilePage() ;
    }

    @Test(priority = 1)
    public void registrationWithGoogleTest() {

        signUpPage = loginPage.registrationGoogle(prop.getProperty("username_google"), prop.getProperty("password_google"));

        anonymRegistrationProfilePage.setBirthDate(new GregorianCalendar(1965, Calendar.MAY, 30));
        anonymRegistrationProfilePage.setGender(Gender.FEMALE);

        Assert.assertEquals(anonymRegistrationProfilePage.getNameText(),prop.getProperty("name_google"),"Name not found");
        Assert.assertEquals(anonymRegistrationProfilePage.getSurnameText(),prop.getProperty("surname_google"),"Surname not found");
        Assert.assertEquals(anonymRegistrationProfilePage.getBirthDate(),"30.05.1965","Birthday date not found");

        anonymRegistrationProfilePage.clickNextButton();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
