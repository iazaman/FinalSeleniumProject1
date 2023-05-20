package us.piit;

import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.AccountSettingsPage;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AccountSettings extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(AccountSettings.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";

    @Test
    public void changePassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AccountSettingsPage accountSettingsPage = new AccountSettingsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        homePage.clickOnSettingButton();
        accountSettingsPage.clickOnAccountSettingsButton();
        accountSettingsPage.clickOnSettingsAccountButton();
        accountSettingsPage.clickOnChangePasswordButton();
        accountSettingsPage.typeOnOldPasswordField(validPassword);






    }

    @Test
    public void addAddressToCompany(){

    }


    @Test
    public void addNewUserManager(){

    }
}
