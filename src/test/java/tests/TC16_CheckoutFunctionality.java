package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC16_CheckoutFunctionality {

    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC16(){
        //16. Home-Arrivals-Add to Basket-Items-Check-out functionality
//1) Open the browser
//2) Enter the URL “http://practice.automationtesting.in/”
//3) Click on Shop Menu
//4) Now click on Home menu button
//5) Test whether the Home page has Three Arrivals only
//6) The Home page must contains only three Arrivals
//7) Now click the image in the Arrivals
//8) Test whether it is navigating to next page where the user can add that book into his basket.
//9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//10) Click on the Add To Basket button which adds that book to your basket
//11) User can view that Book in the Menu item with price.
//12) Now click on Item link which navigates to proceed to check out page.
//13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//14) The total always < subtotal because taxes are added in the subtotal
//15) Now click on Proceed to Check out button which navigates to payment gateway page.
//16) Clicking on Proceed to Checkout button leads to payment gateway page
//17)Clicking on Proceed to Checkout button leads to payment gateway page
        tc1Page.shopMenu.click();
        Driver.getDriver().navigate().refresh();

        tc1Page.homeMenu.click();
        Driver.getDriver().navigate().refresh();

        Assert.assertTrue(tc1Page.arrivals.size()==3);

        tc1Page.arrivals.get(0).click();
        Assert.assertTrue(tc1Page.addToBasket.isDisplayed());

        tc1Page.addToBasket.click();
        Assert.assertTrue(tc1Page.amountOnMenu.isDisplayed());
        System.out.println("tc1Page.amountOnMenu.getText() = " + tc1Page.amountOnMenu.getText());

        tc1Page.itemLink.click();

        Assert.assertTrue(tc1Page.totalPrice.isDisplayed());
        System.out.println("Total Price = " + tc1Page.totalPrice.getText());

        double subtotal= Double.parseDouble(tc1Page.subTotal.getText().substring(1));
        double totalprice= Double.parseDouble(tc1Page.totalPrice.getText().substring(1));

        Assert.assertTrue(totalprice>subtotal);

        tc1Page.checkOutButton.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));


    }




    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
