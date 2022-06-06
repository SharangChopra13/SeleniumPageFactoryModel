package pages;

import core.ActionDrivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends ActionDrivers {

    WebDriver driver;

    static Logger logger = LogManager.getLogger(SignInPage.class);

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginusername")
    private WebElement loginUserName;

    @FindBy(id = "loginpassword")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement login;

    public SignInPage enterLoginUserName(String value){
        typeText(loginUserName, value);
        logger.info("entering login username");
        return this;
    }

    public SignInPage enterLoginPassword(String value){
        typeText(loginPassword, value);
        logger.info("entering login username");
        return this;
    }

    public HomePage clickOnLoginButton(){
        clickOnElement(login);
        logger.info("click on login button");
        return new HomePage(driver);
    }
}
