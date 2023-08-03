package tests;

import com.github.javafaker.Faker;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC30_RegistrationWithEmptyPassword {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC30() throws InterruptedException {

        //30. Registration with empty password
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter valid Email Address in Email-Address textbox
        //5) Enter empty password in password textbox
        //6) Click on Register button
        //7) Registration must fail with a warning message(ie please enter an account password)
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);

        homePage.registEmail.sendKeys(faker.internet().emailAddress());
        homePage.registPassword.sendKeys("");
        homePage.registerButton.click();

        Assert.assertEquals(homePage.errorForRegist.getText(), "");

        String expected= "Error: Please enter an account password.";
        String actual= homePage.errorForRegist.getText();
        Assert.assertTrue(actual.contains(expected));

    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
