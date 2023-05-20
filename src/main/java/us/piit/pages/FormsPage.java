package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class FormsPage extends CommonAPI {
    Logger log = LogManager.getLogger(FormsPage.class.getName());

    public FormsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/forms\"]\n")
    WebElement formsButton;
    @FindBy(xpath = "//a[@href=\"/forms/new\"]/button[@class=\"ui linkedin button\"]\n")
    WebElement formsAddButton;
    @FindBy(xpath = "//input[@name=\"name\" and @type=\"text\"]\n")
    WebElement formsNameField;
    @FindBy(xpath = "//textarea[@name=\"intro\"]\n")
    WebElement formsIntroField;
    @FindBy(xpath = "//textarea[@name=\"outro\"]\n")
    WebElement formsOutroField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement formSaveButton;

    public void clickOnFormSaveButton(){
        clickOn(formSaveButton);
    }

    public String typeOnFormsOutroField(String simpleOutro){
        type(formsOutroField, simpleOutro);
    }

    public String typeOnFormsIntroField(String simpleIntro){
        type(formsIntroField, simpleIntro);
    }

    public String typeOnFormsNameField(String validName){
        type(formsNameField, validName);
    }

    public void clickOnFormsAddButton(){
        clickOn(formsAddButton);
    }

    public void clickOnFormsButton(){
        clickOn(formsButton);
    }


}
