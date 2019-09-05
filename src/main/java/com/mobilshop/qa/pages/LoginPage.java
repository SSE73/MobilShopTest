package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
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

}
