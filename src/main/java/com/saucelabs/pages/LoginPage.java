package com.saucelabs.pages;

import com.saucelabs.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

    @FindBy(id="user-name")
    static  WebElement username;

    @FindBy(id="password")
    static WebElement password;

    @FindBy(id="login-button")
    static WebElement loginButton;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public CartsPage login(String uname, String pwd)
    {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
        return new CartsPage();
    }

}

