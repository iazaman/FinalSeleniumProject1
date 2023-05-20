package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactsPage.class.getName());

    public ContactsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/contacts\"]\n")
    WebElement contactsButton;
    @FindBy(xpath = "//button[@class=\"ui linkedin button\"]\n")
    WebElement contactsExportButton;

    public void clickOnContactsExportButton(){
        clickOn(contactsExportButton);
    }

    public void clickOnContactsButton(){
        clickOn(contactsButton);
    }

}
