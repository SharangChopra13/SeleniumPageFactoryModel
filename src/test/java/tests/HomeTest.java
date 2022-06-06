package tests;

import core.BrowserInstance;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BrowserInstance {

    HomePage homePage;

    @BeforeMethod
    public void creatingObjects(){
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyCategoriesText(){
       String categories = homePage.getTextCategories();
        Assert.assertEquals(categories, "CATEGORIES", "CATEGORIES is not present on home page, Element is returning :- " + categories);
    }
}
