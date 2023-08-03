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

public class TC31_RegistrationWithEmptyEmailandPasswrd {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC31() throws InterruptedException {

        //31. Registration with empty Email-id & password
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on My Account Menu
        //4) Enter empty Email Address in Email-Address textbox
        //5) Enter empty password in password textbox
        //6) Click on Register button
        //7) Registration must fail with a warning message(ie please provide valid email address)
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.clickWithJS(homePage.myAccountButton);

        homePage.registEmail.sendKeys("");
        homePage.registPassword.sendKeys("");
        homePage.registerButton.click();

        String expected="Error: Please provide a valid email address.";
        String actual= homePage.errorForRegist.getText();
        Assert.assertTrue(actual.contains(expected));

    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
