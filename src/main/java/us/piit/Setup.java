package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Setup {
    Logger log = LogManager.getLogger(Setup.class.getName());
    String url = "https://www.freecrm.com/";
    String useCloudEnv = "true" ;


    WebDriver driver;



    public void getCloudDriver( String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd.hub"),cap);

    }


    }
    public void getLocalDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome browser open success");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("Firefox browser open success");
        }


    }


    @Before
    public void setUp() throws MalformedURLException {
        if(useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver("browserstack" , "windows", "11" , "chrome", "113.0.5672.92", "ibnazaman_YDJ2Vj", "CnPWK7HxQRBss2hxsEy7");
        } else if(useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver("chrome");

        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

    }

    @After
    public void tearDown(){
        driver.quit();
        log.info("Browser closed succcessfully");
    }

}
