package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC43_ShopAddtoBasketViewBasketTaxFunctionality {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC43(){
        //43. Shop-Add to Basket-View Basket-Tax Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click on the Add To Basket button which adds that book to your basket
        //5) User can view that Book in the Menu item with price .
        //6) Now click on Item link which navigates to proceed to check out page.
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        //8) The total always < subtotal because taxes are added in the subtotal
        //9) The tax rate variers for India compared to other countries
        //10) Tax rate for indian should be 2% and for abroad it should be 5%
    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
