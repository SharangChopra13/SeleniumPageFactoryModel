package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionDrivers extends Waits{

    WebDriver driver;

    public ActionDrivers(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element){
        waitForElementToBeClickable(element).click();
    }

    public String getText(WebElement element){
        return waitForElementToBeVisible(element).getText();
    }

    public void typeText(WebElement element, String value){

        waitForElementToBeClickable(element).sendKeys(value);
    }

    public void clearField(WebElement element){
        waitForElementToBeClickable(element).clear();
    }

    public void acceptAlert(){
        waitForAlertToAppear();
        driver.switchTo().alert().accept();
    }

    public boolean isDisplayed(WebElement element){
        return waitForElementToBeVisible(element).isDisplayed();
    }
}
