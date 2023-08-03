package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC32_ShopFilterByPriceFunctionality {

    HomePage homePage= new HomePage();
    Actions actions= new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC32() throws InterruptedException {
        //32. Shop-Filter By Price Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Adjust the filter by price between 150 to 450 rps
        //5) Now click on Filter button
        //6) User can view books only between 150 to 450 rps price
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);
        //actions.clickAndHold(homePage.filterLeft).moveToElement(homePage.leftTarget).build().perform();
        homePage.adjustPriceBySlider(150, 450);
        homePage.filterButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("min_price=150&max_price=450"));
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
