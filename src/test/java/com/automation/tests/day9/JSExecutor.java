package com.automation.tests.day9;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
//        driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() throws Exception {
        BrowserUtilities.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest() throws Exception {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

//        you need to cast if reference type is a WebDriver
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
//        x, y coordinates
        for (int i=0 ; i<10 ; i++){
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtilities.wait(3);
        }


        BrowserUtilities.wait(3);
    }
    @Test
    public void scrollToElementTest() throws Exception {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtilities.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
     BrowserUtilities.wait(2);

    }

}
