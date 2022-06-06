package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waits {

    WebDriverWait wait;

    public Waits(WebDriver driver){
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElementToBeClickable(WebElement element){
      return  wait.withMessage("not able to click element:- " + element).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        return wait.withMessage("element is not visible :- " + element).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitAndClickOnStaleElement(WebElement element){
       return wait.withMessage("unable to click on stale element").ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    element.click();
                    return true;
                });
    }

    public Alert waitForAlertToAppear(){
        return wait.withMessage("alert didn't appear").until(ExpectedConditions.alertIsPresent());
    }
}
