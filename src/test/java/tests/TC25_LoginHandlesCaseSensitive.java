package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC25_LoginHandlesCaseSensitive {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC25() throws InterruptedException {

        //25. Login-Handles case sensitive
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter the case changed username in username textbox
        //5) Enter the case chenged password in the password tetxbox
        //6) Now click on login button
        //7) Login must fail saying incorrect username/password.
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.registeredEmailAddress.sendKeys("Emineee@gmail.com");
        homePage.registeredPassword.sendKeys("emine.123");
        homePage.loginButton.click();
        Assert.assertEquals(homePage.errorMessageInLogin.getText(), "Error: The password you entered for the username Emineee@gmail.com is incorrect.");




    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
