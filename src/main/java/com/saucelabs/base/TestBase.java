package com.saucelabs.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties=new Properties();
    public final String configFilePath="./src/config/config.properties";

    public TestBase()
    {
        configFileReader();
    }

    public void initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getApplicationURL());
    }
    public void configFileReader()
    {
        BufferedReader reader;
        try
        {
            reader=new BufferedReader(new FileReader(configFilePath));
            properties = new Properties();
            try
            {
                properties.load(reader);
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration.properties not found at " + configFilePath);
        }
    }
    public String getApplicationURL()
    {
        String url=properties.getProperty("url");
        if (url!=null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


    public void teardown()
    {
        driver.quit();
    }

}
