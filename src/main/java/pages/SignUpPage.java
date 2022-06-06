package pages;

import core.ActionDrivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends ActionDrivers {

    WebDriver driver;

    static Logger logger = LogManager.getLogger(SignUpPage.class);

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sign-username")
    private WebElement userNameField;

    @FindBy(id = "sign-password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement registerButton;

    public SignUpPage enterUserName(String value){
        clearField(userNameField);
        typeText(userNameField, value);
        logger.info("cleared the username field and entered username");
        return this;
    }

    public SignUpPage enterUserPassword(String value){
        clearField(userPasswordField);
        typeText(userPasswordField, value);
        logger.info("cleared the password field and entered password");
        return this;
    }

    public HomePage clickOnRegister(){
        clickOnElement(registerButton);
        logger.info("clicked on register button");
        acceptAlert();
        logger.info("clicked on ok pop-up");
        return new HomePage(driver);
    }
}
