package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC49_MyAccountsAddressFunctionality {

    HomePage homePage= new HomePage();
    Faker faker= new Faker();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC49() throws InterruptedException {

    //49. My Accounts-Address Functionality
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on My Account Menu
    //4) Enter registered username in username textbox
    //5) Enter password in password textbox
    //6) Click on login button
    //7) User must successfully login to the web page
    //8) Click on My account link
    //9) Click on Address link
    //10) Click Edit on Shipping Address
    //11) User can Edit Shipping address
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        Thread.sleep(1000);
        homePage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        homePage.myAccountButton.click();
        homePage.registeredEmailAddress.sendKeys("emine1@gmail.com");
        homePage.registeredPassword.sendKeys("Emine1.123");
        homePage.loginButton.click();
        homePage.addressesButton.click();
        homePage.editButtons.get(1).click();
        homePage.firstnameShippingAddress.sendKeys(faker.name().firstName());
        homePage.lastNameShippingAddress.sendKeys(faker.name().lastName());
        homePage.companyShippingAddress.sendKeys("Apple");
        homePage.countryButtonShippingAddress.click();
        homePage.selectCountries.sendKeys("Turkey"+Keys.ENTER);
        homePage.streetShippingAddrs.sendKeys(faker.address().streetName());
        homePage.cityShippingAddrs.sendKeys("Trabzon");
        homePage.zipCodeShippingAddrss.sendKeys(faker.address().zipCode());
        homePage.provinceShippingAddrss.click();
        homePage.selectProvinceShipAdrss.sendKeys("Trabzon"+ Keys.ENTER);
        ReusableMethods.clickWithJS(homePage.saveAddressButton);

  }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
