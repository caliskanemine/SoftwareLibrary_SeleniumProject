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

public class TC28_RegistrationWithInvalidEmail {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC28() throws InterruptedException {
        //28. Registration with invalid Email-id
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter invalid Email Address in Email-Address textbox
        //5) Enter your own password in password textbox
        //6) Click on Register button
        //7) Registration must fail with a warning message(ie You must enter a valid email address)
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);

        homePage.registEmail.sendKeys("emineee@dshjshf");
        homePage.registPassword.sendKeys(faker.internet().password());
        homePage.registerButton.click();


        String expectedMessage= "Error: Please provide a valid email address.";
        String actualMessage= homePage.errorForRegist.getText();
        Assert.assertEquals(actualMessage, expectedMessage);


    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
