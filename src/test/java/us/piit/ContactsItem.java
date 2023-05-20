package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.ContactsPage;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

public class ContactsItem extends CommonAPI {
    Logger log = LogManager.getLogger(ContactsItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";

    @Test
    public void exportContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactsExportButton();





    }




}
