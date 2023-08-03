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

public class TC27_RegistrationSignIn {


    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC27() throws InterruptedException {


    //27. Registration-Sign-in
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on My Account Menu
    //4) Enter registered Email Address in Email-Address textbox
    //5) Enter your own password in password textbox
    //6) Click on Register button
    //7) User will be registered successfully and will be navigated to the Home page
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);

        homePage.registEmail.sendKeys(faker.internet().emailAddress());
        homePage.registPassword.sendKeys(faker.internet().password());
        homePage.registerButton.click();

        Assert.assertTrue(homePage.dashboardButtton.isDisplayed());





   }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
