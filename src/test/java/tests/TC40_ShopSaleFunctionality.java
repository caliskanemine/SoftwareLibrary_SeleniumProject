package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC40_ShopSaleFunctionality {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC40() throws InterruptedException {
        //40. Shop-Sale Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click on Sale written product in home page
        //5) User can clearly view the actual price with old price stricken for the sale written products
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);
        homePage.saleProducts.get(0).click();
        String actualPrc= homePage.actualPrice.getText();
        String salePrc=homePage.salePrice.getText();

        Assert.assertFalse(actualPrc.equals(salePrc));


    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
