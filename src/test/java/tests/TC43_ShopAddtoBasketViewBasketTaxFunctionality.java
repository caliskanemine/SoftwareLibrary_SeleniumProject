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

import static org.testng.Assert.assertTrue;

public class TC43_ShopAddtoBasketViewBasketTaxFunctionality {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC43() throws InterruptedException {
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
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.shopMenu);
        ReusableMethods.clickWithJS(homePage.addToBaskets.get(faker.number().numberBetween(0,7)));
        ReusableMethods.wait(2);
        String amountOfPrice=homePage.amountOnMenu.getText();
        System.out.println(amountOfPrice);
        ReusableMethods.clickWithJS(homePage.itemLink);
        assertTrue(homePage.subTotal.isDisplayed());
        System.out.println("homePage.subTotal.getText() = " + homePage.subTotal.getText());
        assertTrue(homePage.totalPrice.isDisplayed());
        System.out.println("homePage.totalPrice.getText() = " + homePage.totalPrice.getText());

        Double sub= Double.valueOf(homePage.subTotal.getText().substring(1));
        System.out.println("sub = " + sub);

        Double total= Double.valueOf(homePage.totalPrice.getText().substring(1));
        System.out.println("total = " + total);

        assertTrue(sub<total);

        double indianTax= (sub*2)/100;
        System.out.println("indianTax = " + indianTax);

        double foreignTax= (sub*5)/100;
        System.out.println("foreignTax = " + foreignTax);

        Double tax= Double.valueOf(homePage.tax.getText().substring(1));

        if (tax==indianTax){
            total=sub+indianTax;
            System.out.println("total with indian tax = " + total);
        }
        if (tax==foreignTax){
            total=sub+foreignTax;
            System.out.println("total with foreign tax= " + total);
        }



    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
