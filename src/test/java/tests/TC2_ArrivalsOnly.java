package tests;

import org.checkerframework.checker.builder.qual.CalledMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC2_ArrivalsOnly {


    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC2(){

        //2. Home page with three Arrivals only
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Now click on Home menu button
        tc1Page.shopMenu.click();
        Driver.getDriver().navigate().refresh();

        tc1Page.homeMenu.click();
        Driver.getDriver().navigate().refresh();


        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        Assert.assertTrue(tc1Page.arrivals.size()==3);
    }




    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
