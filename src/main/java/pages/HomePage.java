package pages;

import core.ActionDrivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ActionDrivers {

    WebDriver driver;

   static Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cat")
    private WebElement categories;

    @FindBy(id = "signin2")
    private WebElement signUp;

    @FindBy(id = "login2")
    private WebElement loginHomePage;

    @FindBy(id = "logout2")
    private WebElement logout;

    public SignInPage  clickOnLogin(){
        clickOnElement(loginHomePage);
        logger.info("clicked on login button");
        return new SignInPage(driver);
    }

    public String getTextCategories(){
        logger.info("getting text of categories");
        return getText(categories);
    }

    public SignUpPage clickOnSignUp(){
        logger.info("clicking on signup button");
        clickOnElement(signUp);
        return new SignUpPage(driver);
    }

    public HomePage  clickOnLogout(){
        clickOnElement(logout);
        logger.info("clicked on logout button");
        return this;
    }

    public boolean verifyLogoutIsDisplayed(){
        logger.info("verifying logout is displayed or not");
        return isDisplayed(logout);
    }
}
