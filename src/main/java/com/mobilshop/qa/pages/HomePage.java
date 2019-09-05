package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

}
