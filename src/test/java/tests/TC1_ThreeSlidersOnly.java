package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC1_ThreeSlidersOnly {


    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void Tc1(){


        //1. Home Page with three Sliders only
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(tc1Page.shopMenu);
        Driver.getDriver().navigate().refresh();
        tc1Page.shopMenu.click();

        //4) Now click on Home menu button
        tc1Page.homeMenu.click();
        Driver.getDriver().navigate().refresh();


        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contains only three sliders
        int expectedSliders=3;
        int actualSliders=tc1Page.sliders.size();
        Assert.assertEquals(actualSliders, expectedSliders);
        System.out.println("actualSliders = " + actualSliders);

      /*  while (tc1Page.ad.isDisplayed()){

            Driver.getDriver().navigate().refresh();
        }

       */


        }




    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
