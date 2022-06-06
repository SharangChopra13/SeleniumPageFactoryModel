package tests;

import core.BrowserInstance;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ReadExcel;

public class SignInTest extends BrowserInstance {

        HomePage homePage;

        @BeforeMethod
    public void creatingObjects(){
            homePage = new HomePage(getDriver());
        }

        @Test(dataProviderClass = ReadExcel.class, dataProvider = "getExcelData")
        public void verifySignIn(String userName, String password){
        homePage.clickOnLogin()
                .enterLoginUserName(userName)
                .enterLoginPassword(password)
                .clickOnLoginButton();
            Assert.assertTrue(homePage.verifyLogoutIsDisplayed());
            homePage.clickOnLogout();
        }
}sharangchopra92@gmail.com
