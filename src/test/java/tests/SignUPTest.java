package tests;

import core.BrowserInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.DataProviders;

public class SignUPTest extends BrowserInstance {

    HomePage homePage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void creatingObjects(){
        homePage = new HomePage(getDriver());
        signUpPage = new SignUpPage(getDriver());
    }

    @Test (dataProvider = "SignUpData", dataProviderClass = DataProviders.class)
    public void signUp(String userName, String password){
        homePage.clickOnSignUp()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnRegister();
        String categories = homePage.getTextCategories();
        Assert.assertEquals(categories, "CATEGORIES", "CATEGORIES is not present on home page, Element is returning :- " + categories);
    }
}
