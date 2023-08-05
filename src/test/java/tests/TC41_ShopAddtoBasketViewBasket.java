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

import static org.testng.Assert.*;

public class TC41_ShopAddtoBasketViewBasket {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC41() throws InterruptedException {
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
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);
        ReusableMethods.clickWithJS(homePage.addToBaskets.get(faker.number().numberBetween(0,7)));
        ReusableMethods.wait(2);
        String amountOfPrice=homePage.amountOnMenu.getText();
        System.out.println(amountOfPrice);
        ReusableMethods.waitForVisibility(homePage.viewBasket, 10);
        ReusableMethods.clickWithJS(homePage.viewBasket);
        assertTrue(homePage.subTotal.isDisplayed());
        System.out.println("homePage.subTotal.getText() = " + homePage.subTotal.getText());
        assertTrue(homePage.totalPrice.isDisplayed());
        System.out.println("homePage.totalPrice.getText() = " + homePage.totalPrice.getText());

        Double sub= Double.valueOf(homePage.subTotal.getText().substring(1));
        System.out.println("sub = " + sub);

        Double total= Double.valueOf(homePage.totalPrice.getText().substring(1));
        System.out.println("total = " + total);

        assertTrue(sub<total);

        homePage.checkOutButton.click();

        assertTrue(homePage.billingDetailsText.isDisplayed());
        assertTrue(homePage.yourOrderText.isDisplayed());
        assertTrue(homePage.additionalInfoText.isDisplayed());
        assertTrue(homePage.paymentMethods.isDisplayed());

        homePage.firstName.sendKeys(faker.name().firstName());
        homePage.lastName.sendKeys(faker.name().lastName());
        homePage.email.sendKeys(faker.internet().emailAddress());
        homePage.phone.sendKeys(faker.phoneNumber().cellPhone());
        homePage.countryButton.click();
        homePage.countryList.get(faker.number().numberBetween(0, 248)).click();
        homePage.streetAdress.sendKeys(faker.address().streetName());
        homePage.city.sendKeys(faker.address().cityName());
        homePage.stateOrCountry.sendKeys(faker.country().name());
        homePage.zipCode.sendKeys(faker.address().zipCode());
        homePage.orderNotes.sendKeys("don't panic! I am the tester!!!");
        ReusableMethods.clickWithJS(homePage.paymentCash);
        homePage.placeOrderButton.click();
        String expectedTextforNewPage= "Order Details";
        String actualTextForNewPage= homePage.orderDetailsText.getText();
        Assert.assertEquals(actualTextForNewPage, expectedTextforNewPage);



    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
