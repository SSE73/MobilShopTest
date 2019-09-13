package com.mobilshop.qa.pages;

import com.mobilshop.qa.base.TestBase;
import com.mobilshop.qa.models.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;

public class AnonymRegistrationProfilePage extends TestBase {

    @FindBy(id = "field_fieldName")
    private WebElement nameField;

    @FindBy(id = "field_surname")
    private WebElement surnameField;

    @FindBy(id = "field_birthday")
    private WebElement birthdayDataPicker;

    @FindBy(className = "ui-datepicker-calendar")
    private WebElement tableDayDataPicker;

    @FindBy(className = "ui-datepicker-month")
    private WebElement birthMonthField;

    @FindBy(className = "ui-datepicker-year")
    private WebElement birthYearField;

    @FindBy(xpath = "//input[@value='m']")
    private WebElement maleField;

    @FindBy(xpath = "//input[@value='f']")
    private WebElement femaleField;

    @FindBy(xpath = "//input[@class='button-pro __wide']")
    private WebElement nextButton;

    public AnonymRegistrationProfilePage() {
        PageFactory.initElements(driver,this);
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setSurname(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public String getNameText() {
        return nameField.getAttribute("value");
    }

    public String getSurnameText() {
        return surnameField.getAttribute("value");
    }

    public void setBirthDate(Calendar birthDate) {
        birthdayDataPicker.click();
        new Select(birthMonthField).selectByValue(String.valueOf(birthDate.get(Calendar.MONTH)));
        new Select(birthYearField).selectByValue(String.valueOf(birthDate.get(Calendar.YEAR)));
        SelectDayFromMultiDateCalendar(String.valueOf(birthDate.get(Calendar.DAY_OF_MONTH)));
    }

    public String getBirthDate() {
      return birthdayDataPicker.getAttribute("value");
    }

    public void SelectDayFromMultiDateCalendar(String day) {
        By dayOfCurrentMonth = By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
                        + day + "']");
        driver.findElement(dayOfCurrentMonth).click();
    }

    public void setGender(Gender gender) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        switch (gender) {
            case FEMALE:
                js.executeScript("arguments[0].click();", femaleField);
                break;
            default:
                js.executeScript("arguments[0].click();", maleField);
                break;
        }
    }

    public void clickNextButton() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", nextButton);
    }
}
