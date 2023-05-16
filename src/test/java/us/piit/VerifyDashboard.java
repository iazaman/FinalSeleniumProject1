package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

public class VerifyDashboard extends CommonAPI {
    Logger log = LogManager.getLogger(VerifyDashboard.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    @Test
    public void testDashboardLoadPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);
        log.info("Validate dashboard success");



    }



}


