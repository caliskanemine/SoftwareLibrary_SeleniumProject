package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC19_LoginWithValid {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC19(){

        //19. Log-in with valid username and password
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter registered username in username textbox
        //5) Enter password in password textbox
        //6) Click on login button
        //7) User must successfully login to the web page
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        homePage.myAccountButton.click();
        homePage.registeredEmailAddress.sendKeys("emineee@gmail.com");
        homePage.registeredPassword.sendKeys("Emine.123");
        homePage.loginButton.click();
        Assert.assertTrue(homePage.wholeTextAfterLoggedin.getText().equals("Hello emineee (not emineee? Sign out)"));
        homePage.logOutButton.click();






    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
