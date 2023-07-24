package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC24_LoginPasswodInBullet {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }


    @Test
    public void TC24() throws InterruptedException {


        //24. Log-in -Password should be masked
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter the password field with some characters.
        //5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);
        homePage.registeredPassword.sendKeys("#{jd*");
        Assert.assertEquals(homePage.isBulletSign(), "password");




    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
