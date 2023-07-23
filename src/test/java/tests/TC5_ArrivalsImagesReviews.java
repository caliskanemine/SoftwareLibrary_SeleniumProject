package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC5_ArrivalsImagesReviews {

    HomePage tc1Page= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC5(){

        //5. Home page - Arrivals-Images-Reviews
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Now click on Home menu button
        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals
        //7) Now click the image in the Arrivals
        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        //10) Now clock on Reviews tab for the book you clicked on.
        //11) There should be a Reviews regarding that book the user clicked on
        tc1Page.shopMenu.click();
        Driver.getDriver().navigate().refresh();

        tc1Page.homeMenu.click();
        Driver.getDriver().navigate().refresh();

        Assert.assertTrue(tc1Page.arrivals.size()==3);

        tc1Page.arrivals.get(0).click();
        Assert.assertTrue(tc1Page.addToBasket.isDisplayed());
        tc1Page.reviews.click();
        Assert.assertTrue(tc1Page.reviewsPart.isDisplayed());


        Driver.getDriver().navigate().back();

        tc1Page.arrivals.get(1).click();
        Assert.assertTrue(tc1Page.addToBasket.isDisplayed());
        tc1Page.reviews.click();
        Assert.assertTrue(tc1Page.reviewsPart.isDisplayed());


        Driver.getDriver().navigate().back();

        tc1Page.arrivals.get(2).click();
        Assert.assertTrue(tc1Page.addToBasket.isDisplayed());
        tc1Page.reviews.click();
        Assert.assertTrue(tc1Page.reviewsPart.isDisplayed());


    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
