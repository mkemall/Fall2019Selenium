package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    /**
     * Homework is to improve this method !!!
     * This method return webdriver object based on browser type
     * if you want to use chrome browser , just provide chrome as a parameter
     * @param browserName
     * @return webdriver object
     */
    public static WebDriver createADriver (String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else {
            WebDriverManager.firefoxdriver().setup();
            return new ChromeDriver();
        }

    }


    }


