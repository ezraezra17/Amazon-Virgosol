package com.virgosol.tests;
import com.virgosol.pages.BasePage;
import com.virgosol.utilities.ConfigurationReader;
import com.virgosol.utilities.Driver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends BasePage {


    @DisplayName("Sign into Account")
    @Test
    public void signIn(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        waitSeconds(3);
        cookies();
        waitSeconds(3);
        assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.amazon.com.tr/","title is not displayed");
        login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        assertTrue(Driver.getDriver().getCurrentUrl().contains("signin"),"user couldn't log into the account");












    }

}
