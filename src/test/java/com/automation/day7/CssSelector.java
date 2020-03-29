package com.automation.day7;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://cybertekschool.com/multiple_buttons");
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement home =driver.findElement(By.cssSelector(".nav-link"));
        WebElement btn1=driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement btn2=driver.findElement(By.cssSelector("[name='button2']"));
        WebElement btn3=driver.findElement(By.cssSelector("[id^"));


        // . (dot) means class name in css selector syntax


    }
}
