package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//div[@class='toolbar_logo_img']")
    private WebElement logoImg;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean validateLogoImage(){
        return logoImg.isDisplayed();
    }

}
