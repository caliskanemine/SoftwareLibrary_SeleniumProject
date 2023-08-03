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

public class TC29_RegistrationWithEmptyEmail {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC29() throws InterruptedException {

        //29. Registration with empty Email-id
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter empty Email Address in Email-Address textbox
        //5) Enter your own password in password textbox
        //6) Click on Register button
        //7) Registration must fail with a warning message(ie please provide valid email address)
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);

        homePage.registEmail.sendKeys("");
        homePage.registPassword.sendKeys(faker.internet().password());
        homePage.registerButton.click();

        Assert.assertTrue(homePage.errorForRegist.getText().contains("Error: Please provide a valid email address."));

        //   Assert.assertTrue(Driver.getDriver().getTitle().contains(""));

    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
