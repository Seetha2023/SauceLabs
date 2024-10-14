package com.saucelabs.test;


import com.saucelabs.base.TestBase;
import com.saucelabs.pages.CartsPage;
import com.saucelabs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class LoginPageTest extends TestBase {
    public LoginPage loginPage;
    public CartsPage cartsPage;

    LoginPageTest()
    {
        super();
    }

    @BeforeSuite
    public void setup()
    {
        initializeDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void Login()
    {
        cartsPage= loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        Assert.assertNotNull(cartsPage, "Login credentials are invalid");
    }
}
