package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC50_MyAccountsAccountDetails {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC50() throws InterruptedException {

    //50. My Accounts-Account Details
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on My Account Menu
    //4) Enter registered username in username textbox
    //5) Enter password in password textbox
    //6) Click on login button
    //7) User must successfully login to the web page
    //8) Click on My account link
    //9) Click on Account details
    //10) User can view account details where he can change his password also.
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        homePage.registeredEmailAddress.sendKeys("emineee@gmail.com");
        homePage.registeredPassword.sendKeys("Emine.123");
        homePage.loginButton.click();
        homePage.accountDetails.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account/edit-account"));
        System.out.println("New Password Part's Text = " + homePage.newPassword.getText());
        Assert.assertTrue(homePage.newPassword.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
