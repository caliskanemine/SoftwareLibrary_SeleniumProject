package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC12_AddBook {

    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC12(){
        //12. Home-Arrivals-Add to Basket-Items-Add book
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
//13) Click on textbox value under quantity in Check out page to add or subtract books.
//14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//15) Now click on Update Basket to reflect those changes
//16) User has the feasibility to Update Basket at the time of check out.
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

       // tc1Page.quantityInput.sendKeys("2");
       tc1Page.uptadeBasketButton.click();

       Assert.assertFalse(tc1Page.messageAfterUpdate.getText().equals("Basket updated.") );

    }





    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
