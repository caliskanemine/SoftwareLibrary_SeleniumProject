package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC26_LoginAuthentication {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC26() throws InterruptedException {

        //26. Login-Authentication
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter the case changed username in username textbox
        //5) Enter the case chenged password in the password tetxbox
        //6) Now click on login button
        //7) Once your are logged in, sign out of the site
        //8) Now press back button
        //9) User shouldn’t be signed in to his account rather a general webpage must be visible
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.registeredEmailAddress.sendKeys("Emineee@gmail.com");
        homePage.registeredPassword.sendKeys("emine.123");
        homePage.loginButton.click();
        Driver.getDriver().navigate().back();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://practice.automationtesting.in/my-account/");




    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
