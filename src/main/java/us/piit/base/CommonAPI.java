package us.piit.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import us.piit.utility.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class CommonAPI {
    Logger log = LogManager.getLogger(CommonAPI.class.getName());
    Properties prop = utility.Utility.loadProperties();
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");
    String saucelabUsername = prop.getProperty("saucelabs.username");
    String saucelabsPassword = prop.getProperty("saucelabs.password");
    String implicitWait = prop.getProperty("implicit.Wait" , "5");
    String windowMaximize = prop.getProperty("window.Maximize" , "true");
    String takeScreenshots = prop.getProperty("take.Screenshots",  "false");
    WebDriver driver;


    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd.hub"), cap);

        }


    }

    public void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome browser open success");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("Firefox browser open success");
        }


    }

    @Parameters({"useCloudEnv", "envName", "os", "osVersion", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("11") String osVersion, @Optional("chrome") String browserName, @Optional("111") String browserVersion,
                      @Optional("https://google.com") String url) throws MalformedURLException {
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(envName, os, osVersion, browserName, browserVersion, browserstackUsername, browserstackPassword);
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(browserName);

        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)));
        if(windowMaximize.equalsIgnoreCase("true")){
            driver.manage().window().maximize();
        }

        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Browser closed succcessfully");
    }

    public WebDriver getDriver() {
        return driver;
    }
    public String getCurrentTitle(){
        return driver.getTitle();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
    public void clickOn(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);

    }
    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void hoverOverAndClickOn(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isVisible(WebElement element){
        return element.isDisplayed();
    }
    public boolean isInteractible(WebElement element){
        return element.isEnabled();
    }
    public boolean isChecked(WebElement element){
        return element.isSelected();
    }
}





