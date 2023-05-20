package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CalendarPage extends CommonAPI {
    Logger log = LogManager.getLogger(CalendarPage.class.getName());
    public CalendarPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Calendar')]")
    WebElement calendarButton;
    @FindBy(xpath = "//button[contains(text(), 'New')]")
    WebElement newCalendarButton;
    @FindBy(xpath = "//input[@autocomplete=\"new-password\" and @name=\"title\" and @type=\"text\" and @value=\"\"]\n")
    WebElement calendarTitleField;
    @FindBy(xpath = "//label[text()=\"Start Date\"]\n")
    WebElement calendarStartField;
    @FindBy(xpath = "//label[text()=\"End Date\"]\n")
    WebElement calendarEndField;
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement calendarSaveButton;
    @FindBy(xpath = "//div[@class=\"rbc-event-content\" and @title=\"NewDate\"]\n")
    WebElement createdCalendar;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"trash icon\"]\n")
    WebElement calendarDeleteButton;
    @FindBy(xpath = "//button[@class=\"ui red button\" and i[@aria-hidden=\"true\" and @class=\"remove icon\"] and contains(text(), \"Delete\")]\n")
    WebElement confirmDeleteButton;

    public void clickOnConfirmDeleteButton(){
        clickOn(confirmDeleteButton);
    }

    public void clickOnCalendarDeleteButton(){
        clickOn(calendarDeleteButton);
    }

    public void clickOnCreatedCalendar(){
        clickOn(createdCalendar);
    }

    public void setCalendarSaveButton(){
        clickOn(calendarSaveButton);
    }

    public void setCalendarEndField(String endDate){
        type(calendarEndField, endDate);
    }

    public void setCalendarStartField(String startDate){
        type(calendarStartField, startDate);
    }

    public void setCalendarTitleField(String validCalendarTitle){
        type(calendarTitleField, validCalendarTitle);
    }

    public void clickOnNewCalendarButton(){
        clickOn(newCalendarButton);
    }

    public void clickOnCalendarButton(){
        clickOn(calendarButton);
    }







}




