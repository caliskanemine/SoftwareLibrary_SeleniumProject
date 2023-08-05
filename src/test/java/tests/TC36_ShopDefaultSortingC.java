package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC36_ShopDefaultSortingC {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC36() throws InterruptedException {
        //36. Shop-Default Sorting Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click on Sort by Newness ratings in Default sorting dropdown
        //5) Now user can view the popular products only
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);

        Select sorting= new Select(homePage.sort);
        sorting.selectByVisibleText("Sort by newness");

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=date"));

    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
