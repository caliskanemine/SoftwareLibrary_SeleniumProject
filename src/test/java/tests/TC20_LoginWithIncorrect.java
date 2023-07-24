package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC20_LoginWithIncorrect {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC20(){

        //   20. Log-in with incorrect username and incorrect password
        //        1) Open the browser
        //        2) Enter the URL “http://practice.automationtesting.in/”
        //        3) Click on My Account Menu
        //        4) Enter incorrect username in username textbox
        //        5) Enter incorrect password in password textbox.
        //        6) Click on login button
        //        7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        homePage.myAccountButton.click();
        homePage.registeredEmailAddress.sendKeys("emine@gmail.com");
        homePage.registeredPassword.sendKeys("Emine");
        homePage.loginButton.click();
        Assert.assertEquals(homePage.errorMessageInLogin.getText(), "Error: A user could not be found with this email address.");





    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
