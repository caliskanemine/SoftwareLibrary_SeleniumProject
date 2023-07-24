package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC21_LoginWithEmptyPassword {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC21() throws InterruptedException {

        // 21. Log-in with correct username and empty password
        //        1) Open the browser
        //        2) Enter the URL “http://practice.automationtesting.in/”
        //        3) Click on My Account Menu
        //        4) Enter valid username in username textbox
        //        5) Now enter empty password in the password textbox
        //        6) Click on login button.
        //        7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.registeredEmailAddress.sendKeys("emine@gmail.com");
        homePage.registeredPassword.sendKeys("");
        homePage.loginButton.click();
        Assert.assertEquals(homePage.errorMessageInLogin.getText(), "Error: Password is required.");






    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
