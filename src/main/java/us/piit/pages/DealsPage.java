package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class DealsPage extends CommonAPI {
    Logger log = LogManager.getLogger(DealsPage.class.getName());
    public DealsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/deals\" and i[@class=\"money icon\"] and span[@class=\"item-text\"]]\n")
    WebElement dealsIcon;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"edit icon\"]\n")
    WebElement editDealsButton;
    @FindBy(xpath = "//input[@name=\"commission\" and @placeholder=\"\" and @type=\"text\" and @value=\"\"]\n")
    WebElement dealsCommissionField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement dealSaveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"unhide icon\"]\n")
    WebElement unhideIcon;
    @FindBy(xpath = "<i aria-hidden=\"true\" class=\"add icon\"></i>")
    WebElement addNotesButton;
    @FindBy(xpath = "//textarea[@rows=\"3\"]\n")
    WebElement notesField;
    @FindBy(xpath = "//button[@class=\"ui green button\" and i[@aria-hidden=\"true\" and @class=\"checkmark icon\"] and contains(text(), \"Save\")]\n")
    WebElement saveNotes;

    public void clickOnSaveNotes(){
        clickOn(saveNotes);
    }

    public void typeOnNotesField(String note){
        type(notesField, note);
    }

    public void clickOnAddNotesButton(){
        clickOn(addNotesButton);
    }

    public void clickOnUnhideIcon(){
        clickOn(unhideIcon);
    }

    public void clickOnDealSaveButton(){
        clickOn(dealSaveButton);
    }

    public void setDealsCommissionField(String commision){
        type(dealsCommissionField, commision);
    }

    public void clickOnEditDealsButton(){
        clickOn(editDealsButton);
    }

    public void clickOnDealsButton(){
        clickOn(dealsIcon);
    }




}
