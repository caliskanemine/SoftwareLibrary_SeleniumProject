package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC39_ShopReadMoreFunctionality {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC39(){
        //39. Shop-Read More Functionality
        //        1) Open the browser
        //        2) Enter the URL “http://practice.automationtesting.in/”
        //        3) Click on Shop Menu
        //        4) Click on read more button in home page
        //        5) Read More option indicates the Out Of Stock.
        //        6) Users cannot add the product which has read more options as it was out of stock.



    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
