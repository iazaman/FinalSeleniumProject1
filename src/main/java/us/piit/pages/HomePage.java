package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//div[contains(text(),'No items found')]")
    WebElement homePageHeader;

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/i[1]")
    WebElement clickOnSettingButton;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement clickOnLogoutButton;

    public void clickOnSettingButton(){
        clickOn(clickOnSettingButton);
    }
    public void clickOnLogOutButton(){
        clickOn(clickOnLogoutButton);
        log.info("Click on logout button success");
    }



    public String getHomePageHeader(){
        String text = getElementText(homePageHeader);
        log.info("User login success");
        return text;
    }

}
