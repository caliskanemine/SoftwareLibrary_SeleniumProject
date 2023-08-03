package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC32_ShopFilterByPriceFunctionality {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC32(){
        //32. Shop-Filter By Price Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Adjust the filter by price between 150 to 450 rps
        //5) Now click on Filter button
        //6) User can view books only between 150 to 450 rps price
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
