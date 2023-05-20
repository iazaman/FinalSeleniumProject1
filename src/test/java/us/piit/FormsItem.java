package us.piit;

import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.FormsPage;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FormsItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(FormsItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String validName = "Nelson Mandela";
    String simpleIntro = "This is the 5th month of the year";
    String simpleOutro = "That means the time to act is now";


    @Test
    public void addNotesToForm(){
        LoginPage loginPage = new LoginPage(getDriver());
        FormsPage formsPage = new FormsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        formsPage.clickOnFormsButton();
        formsPage.clickOnFormsAddButton();
        formsPage.typeOnFormsNameField(validName);
        formsPage.typeOnFormsIntroField(simpleIntro);
        formsPage.typeOnFormsOutroField(simpleOutro);
        formsPage.clickOnFormSaveButton();






    }





}
