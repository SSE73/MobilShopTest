package com.mobilshop.qa.base;

import com.mobilshop.qa.util.TestUtil;
import com.mobilshop.qa.util.WebEventListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public TestBase() {
        try {
            prop = new Properties();
            String currentDir = System.getProperty("user.dir");
            FileInputStream ip = new FileInputStream(currentDir +"/src/main/java/com/mobilshop/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

        //т.к. существует баг для такого разрешения экрана driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
