package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AccountSettingsPage extends CommonAPI {
    Logger log = LogManager.getLogger(AccountSettingsPage.class.getName());
    public AccountSettingsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"settings icon\"]\n")
    WebElement settingsSettingButton;
    @FindBy(xpath = "//a[@class=\"active item\"]\n")
    WebElement settingsAccountButton;
    @FindBy(xpath = "//a[@class=\"item\"]\n")
    WebElement changePasswordButton;
    @FindBy(xpath = "//input[@name=\"oldPassword\" and @type=\"password\"]\n")
    WebElement oldPasswordField;

    public String typeOnOldPasswordField(String validPassword){
        type(oldPasswordField, validPassword);
    }

    public void clickOnChangePasswordButton(){
        clickOn(changePasswordButton);
    }

    public void clickOnSettingsAccountButton(){
        clickOn(settingsAccountButton);
    }

    public void clickOnAccountSettingsButton(){
        clickOn(settingsSettingButton);
    }


}
