package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC44_MyAccountsDashboard {

    HomePage homePage= new HomePage();

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
    }

    @Test
    public void TC44(){



    //44. My Accounts - Dashboard
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on My Account Menu
    //4) Enter registered username in username textbox
    //5) Enter password in password textbox
    //6) Click on login button
    //7) User must successfully login to the web page
    //8) Click on Myaccount link which leads to Dashboard
    //9) User must view Dashboard of the site


}
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
