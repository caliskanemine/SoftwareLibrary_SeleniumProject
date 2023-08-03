package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC41_ShopAddtoBasketViewBasket {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC41(){
        //41. Shop-Add to Basket-View Basket Functionality
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Click on the Add To Basket button which adds that book to your basket
        //5) User can view that Book in the Menu item with price .
        //6) Now click on View Basket link which navigates to proceed to check out page.
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        //8) The total always < subtotal because taxes are added in the subtotal
        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        //12) Now click on Place Order button to complete process
        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
