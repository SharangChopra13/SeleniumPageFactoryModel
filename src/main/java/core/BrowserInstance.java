package core;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

public class BrowserInstance {

    WebDriver driver;
    String url = "https://www.demoblaze.com/index.html";

    @BeforeClass
    public void launchBrowser(@Optional("Chrome") String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            driver = ChromeDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("Firefox")) {
           driver = FirefoxDriverManager.firefoxdriver().create();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
