package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
import com.mobilshop.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "st.email")
    WebElement username;

    @FindBy(name="st.password")
    WebElement password;

    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement loginBtn;

    /**
     * Login error text.
     */
    @FindBy(xpath = "//div[@class='input-e login_error']")
    private WebElement errorLoginText;

    @FindBy(xpath = "//a[@data-l='t,google']")
    WebElement buttonGoogle;

    @FindBy(id = "identifierId")
    private WebElement loginGoogle;

    @FindBy(id = "identifierNext")
    private WebElement loginNext;

    @FindBy(name = "password")
    private WebElement passwordGoogle;

    @FindBy(id = "passwordNext")
    private WebElement passwordNext;

    TestUtil testUtil;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    /**
     * Login error get text.
     * @return Login error text
     */
    public final String getErrorLoginText() {
        return errorLoginText.getText();
    }


    public HomePage login(String parUserName, String parPassword){
        username.sendKeys(parUserName);
        password.sendKeys(parPassword);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);
        return new HomePage();
    }

    public HomePage loginGoogle(String loginName, String passwordText){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", buttonGoogle);
        testUtil = new TestUtil();
        testUtil.switchToHandle(1);
        loginGoogle.sendKeys(loginName);
        loginNext.click();
        passwordGoogle.sendKeys(passwordText);
        js.executeScript("arguments[0].click();", passwordNext);
        testUtil.switchToHandle(0);
        return new HomePage();
    }

    public SignUpPage registrationGoogle(String loginName, String passwordText){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", buttonGoogle);
        testUtil = new TestUtil();
        testUtil.switchToHandle(1);
        loginGoogle.sendKeys(loginName);
        loginNext.click();
        passwordGoogle.sendKeys(passwordText);
        js.executeScript("arguments[0].click();", passwordNext);
        testUtil.switchToHandle(0);
        return new SignUpPage();
    }
}
