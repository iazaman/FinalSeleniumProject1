package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

public class LogutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogutTest.class.getName());

    String validEmail = "awafzaman@gmail.com";

    String validPassword = "Takeover2022 ";
    @Test
    public void logOut() {


        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();


        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        org.testng.Assert.assertEquals(actualHeader, expectedHeader);
        log.info("user logged in success");

        waitFor(3);

        homePage.clickOnSettingButton();
        homePage.clickOnLogOutButton();



        String expectedLoginPageHeader = "Forgot your password?";
        String actualLoginPageHeader = loginPage.getActualPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("Forgot password button is displayed");
    }





}


