package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    public SignUpPage() {
        PageFactory.initElements(driver,this);
    }

}
