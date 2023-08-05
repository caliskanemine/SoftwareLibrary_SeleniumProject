package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC46_MyAccountsOrders {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC46() throws InterruptedException {


    //46. My Accounts - Orders
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on My Account Menu
    //4) Enter registered username in username textbox
    //5) Enter password in password textbox
    //6) Click on login button
    //7) User must successfully login to the web page
    //8) Click on My account link
    //9) Click on Orders link
    //10) Click view button
    //11) User must view his Order details,customer details and billing details on clicking view button
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        homePage.registeredEmailAddress.sendKeys("emineee@gmail.com");
        homePage.registeredPassword.sendKeys("Emine.123");
        homePage.loginButton.click();
        homePage.ordersButton.click();

        //no order!

}

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
