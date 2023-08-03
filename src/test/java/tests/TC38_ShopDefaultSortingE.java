package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC38_ShopDefaultSortingE {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC38(){
        //38. Shop-Default Sorting Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click on Sort by High to Low Item in Default sorting dropdown
        //5) Now user can view the popular products only
    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
