package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class CompanyPage extends CommonAPI {
    Logger log = LogManager.getLogger(CompanyPage.class.getName());
    public CompanyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"item-text\" and text()=\"Companies\"]\n")
    WebElement companiesButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"edit icon\"]\n")
    WebElement companiesUnhideIcon;
    @FindBy(xpath = "//button[@class=\"ui tiny basic icon button\" and i[@aria-hidden=\"true\" and @class=\"linkify icon\"]]\n")
    WebElement linkCompanyContactButton;
    @FindBy(xpath = "//input[@aria-autocomplete=\"list\" and @autocomplete=\"off\" and @class=\"search\" and @tabindex=\"0\" and @type=\"text\" and @value=\"\"]\n")
    WebElement companyContactNameField;
    @FindBy(xpath = "//button[@name=\"connect\" and @class=\"ui basic icon positive button\" and i[@aria-hidden=\"true\" and @class=\"check icon\"]]\n")
    WebElement confirmCompanyContactButton;
    @FindBy(xpath = "//button[@class=\"ui tiny basic icon button\" and i[@aria-hidden=\"true\" and @class=\"linkify icon\"]]\n")
    WebElement linkCompanyDealsButton;
    @FindBy(xpath = "//input[@aria-autocomplete=\"list\" and @autocomplete=\"off\" and @class=\"search\" and @tabindex=\"0\" and @type=\"text\" and @value=\"\"]\n")
    WebElement linkCompanyDealField;
    @FindBy(xpath = "//button[@name=\"connect\" and @class=\"ui basic icon positive button\" and i[@aria-hidden=\"true\" and @class=\"check icon\"]]\n")
    WebElement linkCompanyDealButton;

    public void clickOnLinkCompanyDealButton(){
        clickOn(linkCompanyDealField);
    }

    public void typeOnLinkCompanyDealField(String dealName){
        type(linkCompanyDealField, dealName);
    }

    public void clickOnLinkCompanyDealsButton(){
        clickOn(linkCompanyDealsButton);
    }

    public void clickOnConfirmCompanyContactButton(){
        clickOn(confirmCompanyContactButton);
    }

    public void typeOnCompanyContactField(String contactName){
        type(companyContactNameField, contactName);

    }

    public void clickOnLinkCompanyContactButton(){
        clickOn(linkCompanyContactButton);
    }

    public void clickOnCompaniesUnhideIcon(){
        clickOn(companiesUnhideIcon);
    }

    public void clickOnCompaniesButton(){
        clickOn(companiesButton);
    }



}
