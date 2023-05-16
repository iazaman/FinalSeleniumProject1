package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

import java.time.Duration;

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

    @Test
    public void createNewTask(){
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

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Cogmento"));

        WebElement tasksMenuItem = getDriver().findElement(By.xpath("//span[contains(text(), 'Tasks')]"));
        tasksMenuItem.click();

        wait.until(ExpectedConditions.titleContains("Tasks"));

        WebElement createButton = getDriver().findElement(By.xpath("//button[contains(text(), 'Create')]"));
        createButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("title")));

        WebElement titleInput = getDriver().findElement(By.name("title"));
        titleInput.sendKeys("New Task");

        WebElement submitButton = getDriver().findElement(By.xpath("//button[contains(text(), 'Save')]"));
        submitButton.click();

        wait.until(ExpectedConditions.titleContains("Tasks"));


    }



}


