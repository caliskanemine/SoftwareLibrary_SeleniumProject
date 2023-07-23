package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC7_AddToBasketMore {


    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

@Test
public void TC7(){

//7. Home page - Arrivals-Add to Basket with more books
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
//12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
//13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
//14) Click the add to basket button
//15) Now it throws an error prompt like you must enter a value between 1 and 20
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

    tc1Page.quantityInput.sendKeys(Keys.DELETE+"1001");

    tc1Page.uptadeBasketButton.click();

    String actualMessage= tc1Page.messageAfterUpdate.getText();
    Assert.assertFalse(actualMessage.equals("Basket updated."));


}



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}






