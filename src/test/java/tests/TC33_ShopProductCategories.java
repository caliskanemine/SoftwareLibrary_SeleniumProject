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

public class TC33_ShopProductCategories {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC33() throws InterruptedException {
        //33. Shop-Product Categories Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click any of the product links available in the product category
        //5) Now user can view only that particular product
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);
        homePage.products.get(faker.number().numberBetween(0, homePage.products.size()-1)).click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("product"));



    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
